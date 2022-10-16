package com.example.mongo.controller;

import com.example.mongo.model.TacoOrderMongoDto;
import com.example.mongo.repos.TacoMongoRepository;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

  @Autowired
  private TacoMongoRepository orderRepository;

  @GetMapping("/current")
  public String currentOrder() {
    return "orderForm";
  }

  @PostMapping
  public String complete(@Valid @ModelAttribute("tacoOrder") TacoOrderMongoDto tacoOrderMongoDto, Errors errors,
      SessionStatus sessionStatus) {
    if (errors.hasErrors()) {
      return "orderForm";
    }
    log.info("Order submitted: {}", tacoOrderMongoDto);
    orderRepository.save(tacoOrderMongoDto);
    sessionStatus.setComplete();
    return "orderComplete";
  }
}
