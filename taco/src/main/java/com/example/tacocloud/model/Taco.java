package com.example.tacocloud.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Taco {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private final LocalDate createdAt = LocalDate.now();

  @NotNull
  @Size(min = 5, message = "Name must be at least 5 literals")
  private final String name;

  @NotNull
  @ManyToMany
  @Size(min=1, message="You must choose at least 1 ingredient")
  private final List<Ingredient> ingredients;
}
