package com.patika.kredinbizdeservice.model.logmodels;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "logRecords")
public class LogRecord {
    @Id
    private String id;
    private String message;
    private String timestamp;

}

