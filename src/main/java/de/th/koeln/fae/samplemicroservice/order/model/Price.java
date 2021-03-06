package de.th.koeln.fae.samplemicroservice.order.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Access(AccessType.FIELD)
public class Price {

  @Column(name="price")
  private final Double value;

  public Price(){
    this.value = null;
  }

  public Price(Double price){
    if (price >= 0 ){
      this.value = price;
    }else {
      throw new IllegalArgumentException("Price could not be negative.");
    }
  }
}
