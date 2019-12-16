package com.example.springbootvalidation.controller;
import com.example.springbootvalidation.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @RequestMapping("add")
    public String toAdd(User user) {
        return "add";
    }

    @RequestMapping("addUser")
    public String add(@Valid User user, BindingResult result) {
        // @Valid is used to validate the User object received from the user according to the validation we set in the User class.
        // BindResult object contains the validation result and contains any errors that may occur when the User object is not valid.
        // We check if BindResult object has any errors using the if statement below:
        if (result.hasErrors()) {
            // If there is any error, we'll return add, which is the name of the html page that should be displayed
            return "add";
        }
        //If there are no errors we'll display success.html
        System.out.println("Save user =" + user);
        return "success";
    }
}