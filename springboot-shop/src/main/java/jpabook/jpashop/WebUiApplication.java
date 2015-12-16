package jpabook.jpashop;

import jpabook.jpashop.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.boot.builder.*;
import org.springframework.boot.context.web.*;
import org.springframework.context.annotation.*;

/**
 * Created by rigel on 12/16/15.
 */

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration(exclude=ErrorMvcAutoConfiguration.class)
@ComponentScan
public class WebUiApplication extends SpringBootServletInitializer{

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private  MemberRepository memberRepository;

    @Autowired
    private  OrderRepository orderRepository;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebUiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebUiApplication.class, args);

    }
}
