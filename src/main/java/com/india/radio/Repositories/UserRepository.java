package com.india.radio.Repositories;

import com.india.radio.entaties.UsersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<UsersDetails,Integer> {

    UsersDetails findByEmail(String email);
}
