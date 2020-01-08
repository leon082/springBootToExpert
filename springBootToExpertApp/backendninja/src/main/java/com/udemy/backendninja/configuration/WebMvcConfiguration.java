/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udemy.backendninja.configuration;


import com.udemy.backendninja.component.RequestTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 *
 * @author luis.leon
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

    @Autowired
    @Qualifier("requestTimeInterceptor")
    private RequestTimeInterceptor requestTimeInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(requestTimeInterceptor);
    }
    
}
