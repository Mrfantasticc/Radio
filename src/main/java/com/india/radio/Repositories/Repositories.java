package com.india.radio.Repositories;

import com.india.radio.entaties.RadioStationDetails;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Repository
public class Repositories {

    final String mirchiUrl="http://peridot.streamguys.com:7150/Mirchi";

    public Repositories() {
    }

    public String getMirchiUrl() {
        return mirchiUrl;
    }

    public void getStationRegistrationDetails(@ModelAttribute RadioStationDetails radioStationDetails){
        System.out.println(radioStationDetails);

    }
}
