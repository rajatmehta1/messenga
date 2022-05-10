package com.sv.messenga.services;

import com.sv.messenga.dtos.UserDTO;
import com.sv.messenga.exceptions.UserNotFoundException;
import com.sv.messenga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUser(Integer userId) throws UserNotFoundException {
        if(userRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException("User does not exist");
        } else {
            return new UserDTO(userRepository.findById(userId).get());
        }
    }


}
