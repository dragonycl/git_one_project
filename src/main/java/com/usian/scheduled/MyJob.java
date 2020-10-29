package com.usian.scheduled;

import com.usian.service.AService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class MyJob implements Job {
    @Autowired
    private AService aService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        aService.addUser();
        System.out.println("Execute...."+new Date());
    }
}
