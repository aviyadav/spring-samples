package jcg.demo.scheduler.quartz2;
 
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
 
public class QuartzSchedulerApp {
 
    private static final String TRIGGER_NAME = "MyTriggerName";
    private static final String GROUP = "simple_Group";
    private static final String JOB_NAME = "someJob";
    private static Scheduler scheduler;
 
    public static void main(String[] args) throws Exception {
        System.out.println("QuartzSchedulerApp main thread: " + Thread.currentThread().getName());
 
        scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
 
        Trigger trigger =  buildCronSchedulerTrigger();
        scheduleJob(trigger);
 
    }
 
    private static void scheduleJob(Trigger trigger) throws Exception {
 
        JobDetail someJobDetail = JobBuilder.newJob(QuartzJob.class).withIdentity(JOB_NAME, GROUP).build();
 
        scheduler.scheduleJob(someJobDetail, trigger);
 
    }
 
    private static Trigger buildCronSchedulerTrigger() {
        String CRON_EXPRESSION = "0 * * * * ?";
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(TRIGGER_NAME, GROUP)
                .withSchedule(CronScheduleBuilder.cronSchedule(CRON_EXPRESSION)).build();
 
        return trigger;
    }
}