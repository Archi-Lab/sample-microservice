package de.th.koeln.fae.samplemicroservice.order.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Amount {

  @Column(name="amount")
  private final Integer value;

  protected Amount() {
    this.value = null;
  }

  public Amount(Integer value) {
    if (value >= 1) {
      this.value = value;
    } else {
      throw new IllegalArgumentException("Amount could not be negative or zero.");
    }
  }

}
