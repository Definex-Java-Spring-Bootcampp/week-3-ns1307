package com.patika.kredinbizdeservice.model.logmodels;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "errorRecords")
public class ErrorRecord {
    @Id
    private String id;
    private String error;
    private String timestamp;
    private String errorType;


}

