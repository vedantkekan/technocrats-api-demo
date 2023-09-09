package com.technocrats.api.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.listeners.JobListenerSupport;

public class MyJobListener implements JobListener {


    @Override
    public String getName() {
        return "my-job-listener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        System.out.println("NOW WE WILL EXECUTE JOB.... "+ jobExecutionContext.getJobDetail().getKey().getName());
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        System.out.println("OH NOO JOB EXECUTION SKIPPED???? "+ jobExecutionContext.getJobDetail().getKey().getName());
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        System.out.println("HURRAY JOB IS EXECUTED!!!!! "+ jobExecutionContext.getJobDetail().getKey().getName());
    }
}
