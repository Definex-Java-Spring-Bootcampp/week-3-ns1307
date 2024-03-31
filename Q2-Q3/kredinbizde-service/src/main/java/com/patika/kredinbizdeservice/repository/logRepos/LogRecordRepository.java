package com.patika.kredinbizdeservice.repository.logRepos;


import com.patika.kredinbizdeservice.model.logmodels.LogRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface LogRecordRepository extends MongoRepository<LogRecord, String> {

}

