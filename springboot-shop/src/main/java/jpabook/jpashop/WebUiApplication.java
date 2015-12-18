package jpabook.jpashop;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.*;
import org.springframework.boot.context.embedded.*;
import org.springframework.boot.context.web.*;
import org.springframework.context.annotation.*;

/**
 * Created by rigel on 12/16/15.
 */

@SpringBootApplication
public class WebUiApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebUiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebUiApplication.class, args);

    }

    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }

    @Bean
    public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }
}
