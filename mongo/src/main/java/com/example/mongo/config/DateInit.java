package com.example.mongo.config;

import com.example.mongo.model.Ingredient;
import com.example.mongo.model.Type;
import com.example.mongo.repos.IngredientMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DateInit implements ApplicationRunner {

  @Autowired
  private IngredientMongoRepository repository;

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
  }
}
