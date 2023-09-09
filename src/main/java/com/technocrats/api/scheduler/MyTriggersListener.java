package com.technocrats.api.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

public class MyTriggersListener implements TriggerListener {


    @Override
    public String getName() {
        return "my-trigger-listener";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        System.out.println("HURRAY TRIGGER IS FIRED!!!!! "+ trigger.getKey().getName());
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        System.out.println("OH NOO TRIGGER EXECUTION SKIPPED???? "+ trigger.getKey().getName());
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
        System.out.println("HURRAY TRIGGER IS COMPLETED!!!!! "+ trigger.getKey().getName());
    }
}
