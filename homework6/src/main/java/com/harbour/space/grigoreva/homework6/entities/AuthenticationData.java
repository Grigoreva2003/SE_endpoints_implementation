package com.harbour.space.grigoreva.homework6.entities;

import lombok.Getter;

@Getter
public class AuthenticationData {
    private Integer courierId;
    private String login;
    private String password;

    public AuthenticationData(int courierId, String login, String password) {
        this.courierId = courierId;
        this.login = login;
        this.password = password;
    }
}
