package Work1.Project1.Package.interceptor;

import Work1.Project1.Package.interfaces.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sun.misc.IOUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.UUID;

@Component
public class ImplementInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    LoggingService loggingService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name()) && request.getMethod().equals(HttpMethod.GET.name())) {
            loggingService.logRequest(request, null);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

 /*   private static final Logger logger = LoggerFactory.getLogger(ImplementInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
     long startTime = System.currentTimeMillis();
   request.setAttribute("startTime", startTime);
     //   logger.info(" Request URL::" + request.getRequestURL().toString() + ":: Start Time=" + Instant.now());
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
    }


    @Override
    public void afterCompletion
            (HttpServletRequest request, HttpServletResponse response, Object
                    handler, Exception exception) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        logger.info("Request URL::" + request.getRequestURL().toString() +" :: End Time=" + Instant.now()+ " :: Time Taken=" + (Instant.now().toEpochMilli() - startTime));
    }


/*/

