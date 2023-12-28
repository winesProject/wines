package com.std.sbb.global.imagesfile.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///Users/dev/Desktop/java/wines/src/main/resources/static/images/");
//        .addResourceLocations("file:///Users/dev/Desktop/java/wines/src/main/resources/static/images/");
//        .addResourceLocations("file:///Users/yujin/Desktop/work/wines/src/main/resources/static/images/");

    }
}
//    file:///C:/java_work/wines/src/main/resources/static/images/