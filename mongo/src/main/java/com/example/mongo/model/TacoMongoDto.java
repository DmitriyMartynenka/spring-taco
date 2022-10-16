package com.example.mongo.model;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class TacoMongoDto {

  private LocalDate createdAt = LocalDate.now();

  @NotNull
  @Size(min = 5, message = "Name must be at least 5 literals")
  private String name;

  @NotNull
  @Size(min=1, message="You must choose at least 1 ingredient")
  private List<Ingredient> ingredients;

}
