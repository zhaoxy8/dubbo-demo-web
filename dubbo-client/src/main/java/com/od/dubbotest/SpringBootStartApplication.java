package com.od.dubbotest;

import org.springframework.boot.context.web.SpringBootServletInitializer;
import com.od.dubbotest.Application;

public class GunsServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
