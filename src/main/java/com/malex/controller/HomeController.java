package com.malex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String getHome() {
        return "views/home";
    }

    @RequestMapping(path = "/crud", method = RequestMethod.GET)
    public String getCrud() {
        return "views/crud";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "views/login";
    }

}
