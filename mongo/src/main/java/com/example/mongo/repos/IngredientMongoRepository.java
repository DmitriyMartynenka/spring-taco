package com.example.mongo.repos;

import com.example.mongo.model.Ingredient;
import com.example.mongo.model.Type;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientMongoRepository extends CrudRepository<Ingredient, String> {

  List<Ingredient> findAllByType(Type type);
}
