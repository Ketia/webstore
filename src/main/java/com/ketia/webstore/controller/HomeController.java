/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ketia
 */
package com.ketia.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *	Provide "@Controller" annotation for Spring to scan for Controller Class of the Welcome page
 */
@Controller
public class HomeController {

/**
 * 	By using "@RequestMapping("/"), it will tell the Dispatcher that this controller's going to return the Model attribute "welcome" to 
 * 	matching jsp page "/webstore/welcome.jsp". 
 *      @param model
 *      @return 
 */
    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to Spring MVC!");
        model.addAttribute("tagline", "This is the first time to use Spring MVC.");
        return "welcome";
    }
}
