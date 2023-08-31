package com.Hammasir.Mahtab.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private final RequestResponseProcessingTimeInterceptor interceptor;

    public ScheduledTasks(RequestResponseProcessingTimeInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Scheduled(fixedRate = 60000)
    public void reportEveryMinute() {
        long averageResponseTime = interceptor.calculateAverageResponseTime();
        logger.info("Average response time for the last minute: {}ms", averageResponseTime);
        interceptor.clearResponseTimes(); // پاک کردن زمان‌های ذخیره شده
    }

    @Scheduled(fixedRate = 180000)
    public void reportEveryThreeMinutes() {
        long averageResponseTime = interceptor.calculateAverageResponseTime();
        logger.info("Average response time for the last three minutes: {}ms", averageResponseTime);
        interceptor.clearResponseTimes(); // پاک کردن زمان‌های ذخیره شده
    }

    @Scheduled(cron = "0 34 * * * ?")
    public void reportInThirtyFour() {
        long averageResponseTime = interceptor.calculateAverageResponseTime();
        logger.info("Average response time for the last hour at minute 34: {}ms", averageResponseTime);
        interceptor.clearResponseTimes();
    }
}

