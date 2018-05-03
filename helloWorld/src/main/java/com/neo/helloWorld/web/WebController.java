package com.neo.helloWorld.web;

import com.neo.helloWorld.domain.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

    @RequestMapping(value="/get/{name}", method = RequestMethod.GET)
    public User getUser(@PathVariable String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

    @RequestMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result) {
        System.out.println("user:" + user);
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error: list) {
                System.out.println(error.getCode() + "-" + error.getDefaultMessage());
            }
        }
    }
}
