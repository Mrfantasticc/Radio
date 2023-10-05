package com.india.radio.Services;

import com.india.radio.Repositories.UserRepository;
import com.india.radio.entaties.RadioStationDetails;
import com.india.radio.entaties.UsersDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UsersDetails addUser(UsersDetails usersDetails){
        UsersDetails user = userRepository.save(usersDetails);

        return user;
    }
}
