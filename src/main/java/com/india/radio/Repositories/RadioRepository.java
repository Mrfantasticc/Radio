package com.india.radio.Repositories;

import com.india.radio.entaties.RadioStationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface RadioRepository extends JpaRepository<RadioStationDetails,Integer> {


//    @Query(value = "select Radio from RadioStationDetails Radio where Radio.countryName = : country")
//    List<RadioStationDetails> getStationListByCountryName(@RequestParam("country") String country);

    @Query(value = "SELECT Radio.stationURL FROM RadioStationDetails Radio WHERE Radio.countryName = :countryname")
    List<String> getStationUrlsByCountry(@Param("countryname") String countryname);


    @Query("SELECT radio FROM RadioStationDetails radio WHERE " +
            "radio.countryName LIKE CONCAT('%',:query, '%')" +
            "Or radio.cityName LIKE CONCAT('%', :query, '%')" +
            "Or radio.stationName LIKE CONCAT('%', :query, '%')")
    List<RadioStationDetails> search( String query);
}
