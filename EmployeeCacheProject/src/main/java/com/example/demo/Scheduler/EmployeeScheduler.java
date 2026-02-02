package com.example.demo.Scheduler;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.Cache.EmpCache;

@Component
@EnableScheduling
public class EmployeeScheduler {
	
	@Autowired
	EmpCache empCache;
	
	@Scheduled(fixedDelay = 10,initialDelay = 10,timeUnit = TimeUnit.SECONDS)
	public void m()
	{
		empCache.clearCache();
		empCache.fetchAllDataFromDb();
	}

}
