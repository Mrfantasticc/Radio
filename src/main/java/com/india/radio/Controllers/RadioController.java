package com.india.radio.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RadioController {


    @RequestMapping("/")
    public String home(){

        return "index";
    }



    @GetMapping("/userTemplates/home")
    public String showTargetPage() {

        return "userTemplates/home";
    }




}
