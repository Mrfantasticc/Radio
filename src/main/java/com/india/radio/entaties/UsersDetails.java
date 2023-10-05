package com.india.radio.entaties;

import jakarta.persistence.*;
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
public class UsersDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int userId;

    String name;

    @Column(unique = true,nullable = false)
    String email;

    String mobileNo;

    String password;

    String city;

    String role;


}
