/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.UserCredential;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author luis.leon
 */
@Controller
public class LoginController {
    
    private static final String LOGIN_VIEW="login";
    private static final String CONTACTS_VIEW="contacts";
    
    @GetMapping("/")
    public String redirectToLogin(){
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String showLoginForm(Model model,
            @RequestParam(name="error",  required = false) String error,
            @RequestParam(name="logout",  required = false) String logout){
        model.addAttribute("userCredential",new UserCredential());
        model.addAttribute("error",error);
         model.addAttribute("logout",logout);
        return LOGIN_VIEW;
    }
    
    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute(name="userCredential") UserCredential userCredential){
        if(userCredential.getUserName().equals("user")
                && userCredential.getPassword().equals("user")){
             return CONTACTS_VIEW;
        }
       return "redirect:/login?error";
    }
}
