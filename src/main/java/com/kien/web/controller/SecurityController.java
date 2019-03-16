package com.kien.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class SecurityController {

    @RequestMapping(value = "/loginfail")
    public String loginFail(Model model) {
        model.addAttribute("loginError",true);
        return "login";
    }

    @RequestMapping(value = "/logoutsuccess")
    public String logout(Model model) {
        model.addAttribute("logout",true);
        return "login";
    }

}
