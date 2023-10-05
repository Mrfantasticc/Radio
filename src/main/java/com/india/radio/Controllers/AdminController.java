package com.india.radio.Controllers;

import com.india.radio.Services.RadioService;
import com.india.radio.Services.UserService;
import com.india.radio.entaties.RadioStationDetails;
import com.india.radio.entaties.UsersDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    final RadioService radioService;

    final UserService userService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Autowired
    public AdminController(RadioService radioService, TemplateEngine customTemplateEngine, UserService userService) {
        this.radioService = radioService;
        this.userService = userService;
    }

    @RequestMapping("/home")
    public String home(){

        return "adminHome";
    }


    @RequestMapping("/addStations")
    public String addRadioStation(){
        return "addStations";
    }



//       add station from handler

    @PostMapping("/addRadioStation")
    public String addStation(@ModelAttribute RadioStationDetails radioStationDetails, @RequestParam MultipartFile file) throws IOException {
        System.out.println(radioStationDetails);


        System.out.println(file.getOriginalFilename());
        radioStationDetails.setChannelPhoto(file.getOriginalFilename());
        RadioStationDetails radioStation = radioService.addRadioStation(radioStationDetails);

        if(file !=null){
            try {

                File saveFile = new ClassPathResource("static/channelImages").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
                System.out.println(path);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                System.out.println("image uploaded succesfully");

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return "redirect:/admin/addStations";
    }

    @RequestMapping("/addAdmin")
    public String addAdmin(){
        return "addAdmin";
    }



//       add station from handler

    @PostMapping("/addAdminform")
    public String addAdminHandler(@ModelAttribute UsersDetails usersDetails)  {
        System.out.println(usersDetails);
        usersDetails.setPassword(passwordEncoder.encode(usersDetails.getPassword()));
        UsersDetails usersDetails1 = userService.addUser(usersDetails);

        return "redirect:/admin/addAdmin";
    }











//      play station page handler

    @RequestMapping("/adminPlayStation")
    public String playStation(Model model){

        List<RadioStationDetails> radioStationDetails = radioService.allStation();
        model.addAttribute("stations",radioStationDetails);



        return "adminPlayStation";
    }

//    search station page handler

    @GetMapping("/searchStation")
    public String search(@RequestParam("keyword")String keyword, Model model){
        System.out.println(keyword);
        List<RadioStationDetails> radioStationDetails = radioService.searchStation(keyword);
        model.addAttribute("stations",radioStationDetails);

        return "searchedStations";
    }





//        delete and update page handler

    @RequestMapping("/deleteAndUpdateStation")
    public String deleteAndUpdate(Model  model1){

        List<RadioStationDetails> radioStationDetails1 = radioService.allStation();
        model1.addAttribute("stations",radioStationDetails1);



        return "deleteAndUpdateStation";
    }

//    edit station page handler

    @GetMapping("/editStationDts/{id}")
    public String editStation(@PathVariable int id ,Model model){

        System.out.println(id);
        RadioStationDetails byId = radioService.findById(id);
        model.addAttribute("station",byId);
        return "editStationDetails";
    }



//    edit station form handler

    @PostMapping("/editStationDts/updateRadioStation")
    public String updateStation(@ModelAttribute RadioStationDetails radioStationDetails, @RequestParam MultipartFile file) throws IOException {
        System.out.println(radioStationDetails);


        System.out.println(file.getOriginalFilename());
        radioStationDetails.setChannelPhoto(file.getOriginalFilename());
        RadioStationDetails updateRadioStation = radioService.addRadioStation(radioStationDetails);

        if(file !=null){
            try {

                File saveFile = new ClassPathResource("static/channelImages").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
                System.out.println(path);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                System.out.println("image uploaded succesfully");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "redirect:/admin/deleteAndUpdateStation";
    }



    @GetMapping("/deleteStationDts/{id}")
    public String deleteStation(@PathVariable int id ){

        System.out.println(id);
        boolean b = radioService.deleteById(id);
        return "redirect:/admin/deleteAndUpdateStation";
    }


}
