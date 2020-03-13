package org.delivery.controller.wrapper;

import lombok.Data;
import org.delivery.model.security.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationWrapper {

    private String username;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password));
    }
}
