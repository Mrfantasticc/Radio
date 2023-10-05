package com.india.radio.Controllers;

import com.india.radio.Services.RadioService;
import com.india.radio.entaties.RadioStationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    final RadioService radioService;

    @Autowired
    public UserController(RadioService radioService) {
        this.radioService = radioService;
    }

    @RequestMapping("/home")
    public String home(){

        return "home";
    }


    @RequestMapping("/playStation")
    public String playStation(Model model){

        List<RadioStationDetails> radioStationDetails = radioService.allStation();
        model.addAttribute("stations",radioStationDetails);



        return "userPlayStation";
    }


    @GetMapping("/searchStation")
    public String search(@RequestParam("keyword")String keyword, Model model){
        System.out.println(keyword);
        List<RadioStationDetails> radioStationDetails = radioService.searchStation(keyword);
        model.addAttribute("stations",radioStationDetails);

        return "searchedStations";
    }


}
