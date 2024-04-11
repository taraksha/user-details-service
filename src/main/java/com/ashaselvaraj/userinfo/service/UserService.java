package com.ashaselvaraj.userinfo.service;

import com.ashaselvaraj.userinfo.dto.UserDTO;
import com.ashaselvaraj.userinfo.entity.User;
import com.ashaselvaraj.userinfo.entity.mapper.UserMapper;
import com.ashaselvaraj.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        User user = userRepo.save(UserMapper.Instance.mapUserDTOToUser(userDTO));
        return UserMapper.Instance.mapUserToUserDTO(user);
    }

    public ResponseEntity<UserDTO> findUserById(Integer userId) {
        Optional<User>  userFromDB= userRepo.findById(userId);
        if(userFromDB.isPresent()){
            return  new ResponseEntity<>(UserMapper.Instance.mapUserToUserDTO(userFromDB.get()), HttpStatus.OK);
        }
        return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
