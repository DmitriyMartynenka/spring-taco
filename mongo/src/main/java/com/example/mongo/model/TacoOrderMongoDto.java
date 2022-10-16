package com.example.mongo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tacoOrder")
public class TacoOrderMongoDto implements Serializable {

  private final Long serialVersionUID=1L;

  @Id
  private String id;

  private LocalDate createdAt = LocalDate.now();

  @NotBlank(message="Delivery name is required")
  private String deliveryName;

  @NotBlank(message="Delivery street is required")
  private String deliveryStreet;

  @NotBlank(message="Delivery city is required")
  private String deliveryCity;

  @NotBlank(message="Delivery state is required")
  private String deliveryState;

  @NotBlank(message="Delivery zip is required")
  private String deliveryZip;

//  @CreditCardNumber(message = "Credit card number is invalid")
  private String ccNumber;

  @Pattern(regexp ="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY")
  private String ccExpiration;

  @Digits(integer = 3, fraction = 0, message="CVV is invalid")
  private String ccCVV;

  private List<TacoMongoDto> tacos = new ArrayList<>();

  public void addTaco(TacoMongoDto tacoMongoDto) {
    this.tacos.add(tacoMongoDto);
  }
}
