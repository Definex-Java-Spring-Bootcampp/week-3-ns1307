package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.logmodels.ErrorRecord;
import com.patika.kredinbizdeservice.model.logmodels.LogRecord;
import com.patika.kredinbizdeservice.repository.logRepos.ErrorRecordRepository;
import com.patika.kredinbizdeservice.repository.logRepos.LogRecordRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public class LogService {
    @Autowired
    private LogRecordRepository logRecordRepository;

    @Autowired
    private ErrorRecordRepository errorRecordRepository;

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public LogService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLog(String message) {
        // Log mesajını Kafka'ya gönderir
        kafkaTemplate.send("log-topic", message);
    }

    public void logError(String error) {
        //Hata mesajlarını Kafka'ya gönderir
        kafkaTemplate.send("error-topic", error);
    }

    @KafkaListener(topics = "log-topic", groupId = "logGroup")
    public void handleLogMessage(String message) {
        //Kafkadan gelen log mesajlarını mongoDB'ye işler.
        LogRecord logRecord = new LogRecord();
        logRecord.setMessage(message);
        logRecord.setTimestamp(LocalDateTime.now().toString());
        logRecordRepository.save(logRecord);
    }

    @KafkaListener(topics = "error-topic", groupId = "errorGroup")
    public void handleError(String error) {
        //Kafkadan gelen error mesajlarını mongoDB'ye işler.
        ErrorRecord errorRecord = new ErrorRecord();
        errorRecord.setError(error);
        errorRecord.setTimestamp(LocalDateTime.now().toString());
        errorRecordRepository.save(errorRecord);
    }

}
