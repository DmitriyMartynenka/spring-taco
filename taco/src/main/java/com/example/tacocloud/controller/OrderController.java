package com.example.tacocloud.controller;

import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.repos.OrderRepository;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
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
  private OrderRepository orderRepository;

  @GetMapping("/current")
  public String currentOrder() {
    return "orderForm";
  }

  @PostMapping
  public String complete(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus) {
    if (errors.hasErrors()) {
      return "orderForm";
    }

    log.info("Order submitted: {}", tacoOrder);
    orderRepository.save(tacoOrder);
    sessionStatus.setComplete();
    return "orderComplete";
  }
}
