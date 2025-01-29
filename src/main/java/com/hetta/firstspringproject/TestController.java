package com.hetta.firstspringproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
    @GetMapping("/hello")
    public @ResponseBody String hello(@RequestParam String s){
        return "Hello " + s;
    }
}
