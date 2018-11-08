package de.th.koeln.fae.samplemicroservice.order.model;

import javax.persistence.Embeddable;

@Embeddable
public class Amount {

  private final Integer value;

  public Amount() {
    this.value = null;
  }

  public Amount(Integer amount) {
    if (amount >= 1) {
      this.value = amount;
    } else {
      throw new IllegalArgumentException("Amount could not be negative or zero.");
    }
  }

  public Integer getValue() {
    return value;
  }
}
