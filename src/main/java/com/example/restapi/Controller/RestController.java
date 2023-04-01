package com.example.restapi.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping(value = "/")
    public String  getPage(){
        return "Welcome";
    }
}
