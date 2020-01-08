/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udemy.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author luis.leon
 */
@Component("exampleComponent")
public class ExampleComponent {
    
    private static final Log LOGGER= LogFactory.getLog(ExampleComponent.class);
    
    public void sayHello(){
        LOGGER.info("Hello Form ExampleComponent");
    }
    
    
}
