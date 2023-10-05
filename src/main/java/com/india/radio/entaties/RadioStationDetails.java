package com.india.radio.entaties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table
@Entity
public class RadioStationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String countryName;

    String cityName;

    String stationName;

    String stationURL;

    double stationFrequency;


    String channelPhoto;


}
