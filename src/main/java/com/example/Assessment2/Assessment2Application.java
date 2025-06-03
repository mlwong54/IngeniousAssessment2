package com.example.Assessment2;

import com.example.Assessment2.Job.StockJob;
import org.quartz.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Assessment2Application {
	public static void main(String[] args) {
		SpringApplication.run(Assessment2Application.class, args);
	}

	@Bean
	public JobDetail dailyJobDetail() {
		return JobBuilder.newJob(StockJob.class)
				.withIdentity("stockJob")
				.storeDurably()
				.build();
	}

    @Bean
    public Trigger dailyJobTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(dailyJobDetail())
                .withIdentity("dailyJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 * * ?")) // 12:00 AM daily
                .build();
    }

}
