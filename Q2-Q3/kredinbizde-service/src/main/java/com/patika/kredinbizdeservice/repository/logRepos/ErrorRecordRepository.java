package com.patika.kredinbizdeservice.repository.logRepos;


import com.patika.kredinbizdeservice.model.logmodels.ErrorRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface ErrorRecordRepository extends MongoRepository<ErrorRecord, String> {
}
