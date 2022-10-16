package com.example.tacocloud.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
@Entity
public class TacoOrder implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

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

  @CreditCardNumber(message = "Credit card number is invalid")
  private String ccNumber;

  @Pattern(regexp ="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY")
  private String ccExpiration;

  @Digits(integer = 3, fraction = 0, message="CVV is invalid")
  private String ccCVV;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Taco> tacos = new ArrayList<>();

  public void addTaco(Taco taco) {
    this.tacos.add(taco);
  }
}
