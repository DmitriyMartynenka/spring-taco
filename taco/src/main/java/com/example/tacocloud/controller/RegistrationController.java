package com.example.tacocloud.controller;

import com.example.tacocloud.model.RegistrationForm;
import com.example.tacocloud.model.Usr;
import com.example.tacocloud.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping
  public String registrationForm() {
    return "registration";
  }

  @PostMapping
  public String processRegistry(RegistrationForm form) {
    Usr entity = form.formToUser(passwordEncoder);
    userRepository.save(entity);
    return "redirect:/login";
  }
}
