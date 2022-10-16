package com.example.tacocloud.repos;

import com.example.tacocloud.model.Usr;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usr, Long> {

  Usr findByUsername(String username);

  @Override
  List<Usr> findAll();
}
