package com.Hammasir.springboot.scheduling;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class RequestResponseProcessingTimeInterceptor implements HandlerInterceptor, Interceptor {
    private final List<Long> responseTimes = new ArrayList<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UUID uuid = UUID.randomUUID();
        request.setAttribute("start" , System.currentTimeMillis());
        request.setAttribute("request-id", uuid);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long duration = System.currentTimeMillis() - (long) request.getAttribute("start");
        addResponseTimes(duration);
    }

    public void addResponseTimes(long duration) {
        responseTimes.add(duration);
    }

    public synchronized long calculateAverageResponseTime() {
        if (responseTimes.isEmpty()) {
            return 0;
        }
        return (long) responseTimes.stream()
                .mapToLong(Long::longValue)
                .average()
                .orElse(0);
    }
}
