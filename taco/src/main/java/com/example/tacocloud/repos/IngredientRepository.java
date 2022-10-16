package com.example.tacocloud.repos;

import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.model.Ingredient.Type;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

  @Override
  List<Ingredient> findAll();

  List<Ingredient> findAllByType(Type type);
}
