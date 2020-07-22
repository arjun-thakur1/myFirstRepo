package Work1.Project1.Package.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class ImplementInterceptorAppConfig  extends WebMvcConfigurerAdapter {
        @Autowired
        ImplementInterceptor implementInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(implementInterceptor);
        }
    }

