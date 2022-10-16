package com.example.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ingredient")
@AllArgsConstructor
public class Ingredient {

  @Id
  private String id;
  private String name;

  private Type type;
}
