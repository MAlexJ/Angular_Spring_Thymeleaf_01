package com.malex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return "Controller";
    }


    @RequestMapping( method = RequestMethod.GET)
    public String home(){
        return  "index";
    }
}
