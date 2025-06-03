package com.example.Assessment2.Job;

import com.example.Assessment2.Service.StockService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import org.springframework.stereotype.Component;

@Component
public class StockJob implements Job  {

    private final StockService stockService;

    public StockJob(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public void execute(JobExecutionContext context) {
       stockService.stockInsertDaily();
    }
}
