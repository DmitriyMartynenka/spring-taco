package com.example.mongo.controller;

import com.example.mongo.model.Ingredient;
import com.example.mongo.model.TacoMongoDto;
import com.example.mongo.model.TacoOrderMongoDto;
import com.example.mongo.model.Type;
import com.example.mongo.repos.IngredientMongoRepository;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

  @Autowired
  private IngredientMongoRepository repository;

  @ModelAttribute
  public void addIngredientsToModel(Model model) {
    Type[] types = Type.values();
    for(Type type: types) {
      List<Ingredient> allByType = repository.findAllByType(type);
      model.addAttribute(type.toString().toLowerCase(), allByType);
    }
  }

  @ModelAttribute(value = "tacoOrder")
  public TacoOrderMongoDto order() {
    return new TacoOrderMongoDto();
  }

  @ModelAttribute(name = "taco")
  public TacoMongoDto taco() {
    return new TacoMongoDto();
  }

  @GetMapping
  public String showDesignForm() {
    return "design";
  }

  @PostMapping
  public String processTaco(@Valid  @ModelAttribute("taco") TacoMongoDto tacoMongoDto, Errors errors,
      @ModelAttribute("tacoOrder") TacoOrderMongoDto tacoOrderMongoDto) {
    if(errors.hasErrors()) {
      return "design";
    }
    tacoOrderMongoDto.addTaco(tacoMongoDto);
    log.info("Processing taco: {}", tacoMongoDto);
    return "redirect:/orders/current";
  }
}
