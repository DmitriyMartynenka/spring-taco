package com.example.tacocloud.config;

import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.model.Ingredient.Type;
import com.example.tacocloud.model.Taco;
import com.example.tacocloud.model.Usr;
import com.example.tacocloud.model.enums.Role;
import com.example.tacocloud.repos.IngredientRepository;
import com.example.tacocloud.repos.TacoRepository;
import com.example.tacocloud.repos.UserRepository;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DateInit implements ApplicationRunner {

  @Autowired
  private IngredientRepository repository;

  @Autowired
  private PasswordEncoder encoder;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TacoRepository tacoRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    repository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
    repository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
    repository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
    repository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
    repository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
    repository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
    repository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
    repository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
    repository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
    repository.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
    userRepository.save(new Usr("admin", encoder.encode("admin"), "admin", "admin", Collections.singleton(Role.ADMIN)));
    userRepository.save(new Usr("dima", encoder.encode("dima"), "dima", "dima", Collections.singleton(Role.USER)));

    Taco taco1 = new Taco("dimas", List.of(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
        new Ingredient("COTO", "Corn Tortilla", Type.WRAP)));
    Taco taco2 = new Taco("dimasasa", List.of(new Ingredient("COTO", "Corn Tortilla", Type.WRAP)));
    tacoRepository.save(taco1);
    tacoRepository.save(taco2);
  }
}
