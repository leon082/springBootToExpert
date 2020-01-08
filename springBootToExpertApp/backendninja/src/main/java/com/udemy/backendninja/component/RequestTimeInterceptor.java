/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udemy.backendninja.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author luis.leon
 */
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o) throws Exception {
        hsr.setAttribute("startTime", System.currentTimeMillis());
        return true;
        
    }

    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
        long stratTime = (long) hsr.getAttribute("startTime");
        LOG.info("--REQUEST URL: '" +hsr.getRequestURL().toString() +  "' --TOTAL TIME: '" + (System.currentTimeMillis() -stratTime) + "'ms");
    }

}
