package com.example.tacocloud.repos;

import com.example.tacocloud.model.Taco;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {

  @Query(value = "select * from taco t order by t.id Desc limit 5", nativeQuery = true)
  List<Taco> findRecent();
}
