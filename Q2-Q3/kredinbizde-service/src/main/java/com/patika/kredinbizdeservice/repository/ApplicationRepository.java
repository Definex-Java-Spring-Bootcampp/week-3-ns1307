package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApplicationRepository {
    @Autowired
    private LogService logService;
    private List<Application> applicationList = new ArrayList<>();

    public Application save(Application application) {
        logService.sendLog("new application: " + application.getUser().getEmail() + "," + application.getLoan().getBank());
        applicationList.add(application);
        return application;
    }
}
