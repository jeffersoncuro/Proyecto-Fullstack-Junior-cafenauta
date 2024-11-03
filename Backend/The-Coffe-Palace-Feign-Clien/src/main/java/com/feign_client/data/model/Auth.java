package com.feign_client.data.model;

import lombok.Data;

@Data
public class Auth {
    private String email;
    private String password;
}