package com.example.tacocloud.model;

import com.example.tacocloud.model.enums.Role;
import java.util.Collections;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

  private String username;
  private String password;
  private String firstName;
  private String lastName;

  public Usr formToUser(PasswordEncoder encoder) {
    return new Usr(
        this.username,
        encoder.encode(password),
        this.firstName,
        this.lastName,
        Collections.singleton(Role.USER));
  }
}
