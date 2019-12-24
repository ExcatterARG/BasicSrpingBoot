package com.example.springbootexception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("/add")
    public String add() {
        int num = 10 / 0;
        return "add";
    }
    /* Commented because we have global handler exceptions */

//    @ExceptionHandler(java.lang.ArithmeticException.class)
//    public ModelAndView handlerArithmeticException(Exception e) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", e.toString());
//        modelAndView.setViewName("mathError");
//        return modelAndView;
//    }
    @RequestMapping("/update")
    public String update() {
        String name = null;
        name = name.toLowerCase(); // this line will cause NullPointerException because it calls a method on a null object
        return "update";
    }
    /* Commented because we have global handler exceptions */

//    @ExceptionHandler(value={java.lang.NullPointerException.class})
//    public ModelAndView handlerNullPointerException(Exception e) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", e.toString());
//        modelAndView.setViewName("nullPointerError");
//        return modelAndView;
//    }
}