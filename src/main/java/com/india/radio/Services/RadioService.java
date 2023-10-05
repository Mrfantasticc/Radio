package com.india.radio.Services;

import com.india.radio.Repositories.RadioRepository;
import com.india.radio.entaties.RadioStationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RadioService {

    final RadioRepository radioRepository;

    @Autowired
    public RadioService(RadioRepository radioRepository) {
        this.radioRepository = radioRepository;
    }

    public RadioStationDetails addRadioStation(RadioStationDetails radioStationDetails){
        RadioStationDetails savedStation = radioRepository.save(radioStationDetails);

        return savedStation;
    }

//    public List<RadioStationDetails> getStationByCountryName(String countryName) {
//        List<RadioStationDetails> listByCountryName = radioRepository.getStationListByCountryName(countryName);
//
//        return listByCountryName;
//
//    }


    public List<String> getStationUrlsByCountry(String countryName) {
        List<String> stationUrls = radioRepository.getStationUrlsByCountry(countryName);
        return stationUrls;
    }


    public List<RadioStationDetails> searchStation(String keyword) {
        List<RadioStationDetails> search = radioRepository.search(keyword);
        return search;
    }

    public List<RadioStationDetails> allStation(){
        List<RadioStationDetails> all = radioRepository.findAll();

        return all;
    }
    
    public RadioStationDetails findById(int id){
        return radioRepository.findById(id).get();
    }


    public boolean deleteById(int id){
        RadioStationDetails radioStationDetails = radioRepository.findById(id).get();
        if (radioStationDetails !=null){
            radioRepository.delete(radioStationDetails);
            return true;
        }
        return false;
    }
}
