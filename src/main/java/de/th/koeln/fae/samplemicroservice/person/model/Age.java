package de.th.koeln.fae.samplemicroservice.person.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Age {

  @Column(name="age")
  private final Integer value;

  public Age(){
    this.value = null;
  }

  public Age(Integer age){
    this.value = validateAge(age);
  }

  private Integer validateAge(Integer age){
    if (age >= 0){
      return age;
    }else {
      throw new IllegalArgumentException("Age could not be negative.");
    }
  }

  public Integer getValue() {
    return value;
  }
}
