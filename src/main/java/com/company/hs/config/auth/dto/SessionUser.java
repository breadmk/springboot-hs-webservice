package com.company.hs.config.auth.dto;

import com.company.hs.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }
}
