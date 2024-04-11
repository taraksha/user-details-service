package com.ashaselvaraj.userinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private int userId;
    private String userName;
    private String userPassword;
    private String userAddress;
    private String userCity;
}
