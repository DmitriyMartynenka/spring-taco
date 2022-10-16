package com.example.tacocloud.controller.rest;

import com.example.tacocloud.model.Taco;
import com.example.tacocloud.repos.TacoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/tacos", produces = "application/json")
public class TacoRestController {

  @Autowired
  private TacoRepository tacoRepository;

  @GetMapping("/recent")
  public List<Taco> findRecent() {
    return tacoRepository.findRecent();
  }

  @GetMapping("/{id}")
  public Taco getById(@PathVariable Long id) {
    Optional<Taco> tacoFromRepo = tacoRepository.findById(id);
    return tacoFromRepo.orElse(null);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Taco add(@RequestBody Taco taco) {
    return tacoRepository.save(taco);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    tacoRepository.deleteById(id);
  }

}
