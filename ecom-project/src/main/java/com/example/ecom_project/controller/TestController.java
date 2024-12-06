package com.example.ecom_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{

    /*@RequestMapping("/api")*/
    public String greet()
    {
        System.out.println("Inside greet method of home controller");
        return "Hello World";
    }
}
