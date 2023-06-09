package edu.ssafy.find_store.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@WebFilter("/*")
public class ApiRateLimitFilter implements Filter {
    private AtomicInteger count;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        count = new AtomicInteger(0);
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        count.getAndIncrement();
        log.info("do filter count={}", count.intValue());
        if (count.intValue() > 10) {
            ((HttpServletResponse) response).setStatus(HttpStatus.SC_TOO_MANY_REQUESTS);
            return;
        }
        chain.doFilter(request, response);
    }

    @Scheduled(cron = "0 0/1 * * * *")
    private void deleteCount() {
        log.info("deleteCount");
        count.set(0);
    }
}
