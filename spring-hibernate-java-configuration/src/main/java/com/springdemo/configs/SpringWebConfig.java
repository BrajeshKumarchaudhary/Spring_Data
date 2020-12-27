package com.springdemo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Subhash Lamba on 19-01-2017.
 */
@Configuration
@ComponentScan({ "com.springdemo" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver  viewResolver () {
        InternalResourceViewResolver  viewResolver=new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;

    }
}
