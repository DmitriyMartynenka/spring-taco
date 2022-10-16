package com.example.tacocloud.service;

import com.example.tacocloud.model.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestTemplateService {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/{id}")
  public Taco getTacoByRest(@PathVariable Long id) {
    return restTemplate.getForObject("http://localhost:8080/api/tacos/{id}", Taco.class, id);
  }
}
