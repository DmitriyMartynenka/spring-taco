package com.example.tacocloud.controller;

import com.example.tacocloud.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  @PreAuthorize("hasAuthority('ADMIN')")
  public String getUsers(Model model) {
    model.addAttribute("users", userRepository.findAll());
    return "users";
  }
}
