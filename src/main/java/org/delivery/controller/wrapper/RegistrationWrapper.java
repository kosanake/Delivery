package org.delivery.controller.wrapper;

import lombok.Data;
import org.delivery.model.security.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationWrapper {

    private String userName;
    private String userPassword;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(userName, passwordEncoder.encode(userPassword));
    }
}
