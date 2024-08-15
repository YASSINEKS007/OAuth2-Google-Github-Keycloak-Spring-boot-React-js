package me.projects.backend.configs;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;
import java.util.logging.Logger;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger(RequestLoggingInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("Incoming Request Data:");
        LOGGER.info("URI: " + request.getRequestURI());
        LOGGER.info("Method: " + request.getMethod());
        LOGGER.info("Headers:");

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            LOGGER.info(headerName + ": " + request.getHeader(headerName));
        }

        LOGGER.info("Query Parameters:");
        request.getParameterMap().forEach((key, value) -> LOGGER.info(key + ": " + String.join(", ", value)));

        return true;
    }
}

