package com.ashaselvaraj.userinfo.contoller;

import com.ashaselvaraj.userinfo.dto.UserDTO;
import com.ashaselvaraj.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService=userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
       UserDTO savedUserDTO = userService.addUser(userDTO);
       return new ResponseEntity<>(savedUserDTO, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUserById/{userId}")
    public ResponseEntity<UserDTO> fetchUserDetailsById(@PathVariable Integer userId){
        System.out.println("Inside fetch user: "+ userId);
        return userService.findUserById(userId);
    }

}
