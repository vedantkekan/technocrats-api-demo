package com.technocrats.api.scheduler;

import org.apache.commons.lang3.time.DateUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

import java.util.Date;
import java.util.List;

import static org.quartz.impl.matchers.GroupMatcher.jobGroupEquals;

public class OrderScheduler {


    public static void main(String args[]) {

        SchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        try {

            Scheduler scheduler = stdSchedulerFactory.getScheduler();

            //Define Schedules
            JobDetail simpleJob = JobBuilder.newJob(SimpleJob.class).withIdentity("myJob", "group1").usingJobData("jobSays", "Hello World!").usingJobData("myFloatValue", 3.141f).build();
            Trigger simpleJobTrigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(40).repeatForever()).build();

            JobDetail jobA = JobBuilder.newJob(JobA.class).withIdentity("jobA", "group2").build();
            Trigger triggerA = TriggerBuilder.newTrigger().withIdentity("triggerA", "group2").startNow().withPriority(15).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(40).repeatForever()).build();

            JobDetail jobB = JobBuilder.newJob(JobB.class).withIdentity("jobB", "group2").build();
            Trigger triggerB = TriggerBuilder.newTrigger().withIdentity("triggerB", "group2").startNow().withPriority(10).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever()).build();


            JobDetail job3 = JobBuilder.newJob(JobB.class).withIdentity("job3", "group3").build();
            Trigger misFiredTrigger3 = TriggerBuilder.newTrigger().withIdentity("misFiredTriggerA","group3")
                    .startAt(DateUtils.addSeconds(new Date(), -10))
                    .build();


            TriggerKey triggerKey = new TriggerKey("job4", "group3");
            JobDetail job4 = JobBuilder.newJob(JobB.class).withIdentity("job4", "group3").build();
            Trigger misFiredTrigger4 = TriggerBuilder.newTrigger().withIdentity(triggerKey)
                    .startAt(DateUtils.addSeconds(new Date(), -100))
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withMisfireHandlingInstructionFireNow())
                    .build();

            //Add Schedules
           // scheduler.scheduleJob(simpleJob, simpleJobTrigger);
           // scheduler.scheduleJob(jobA, triggerA);
            //scheduler.scheduleJob(jobB, triggerB);
           // scheduler.scheduleJob(job3, misFiredTrigger3);
            scheduler.scheduleJob(job4, misFiredTrigger4);



            //Jobs Listener
            MyJobListener myJobListener = new MyJobListener();
            MyTriggersListener myTriggersListener = new MyTriggersListener();
            //scheduler.getListenerManager().addJobListener(myJobListener, jobGroupEquals("group3"));
            scheduler.getListenerManager().addTriggerListener(myTriggersListener, KeyMatcher.keyEquals(triggerKey));
            //Start Schedule
            scheduler.start();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
