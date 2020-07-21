package Work1.Project1.Package.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger logger = LoggerFactory.getLogger(ImplementInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
  //      String requestId = UUID.randomUUID().toString();
       long startTime = System.currentTimeMillis();
       request.setAttribute("startTime", startTime);
        logger.info(" Request URL::" + request.getRequestURL().toString() + ":: Start Time=" + Instant.now());
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
          //  System.out.println("Post Handle method is Calling");
    }


    @Override
    public void afterCompletion
            (HttpServletRequest request, HttpServletResponse response, Object
                    handler, Exception exception) throws Exception {
        //  System.out.println("Request and Response is completed");
        long startTime = (Long) request.getAttribute("startTime");
        logger.info("Request URL::" + request.getRequestURL().toString() +" :: End Time=" + Instant.now()+ " :: Time Taken=" + (Instant.now().toEpochMilli() - startTime));
    }



}
