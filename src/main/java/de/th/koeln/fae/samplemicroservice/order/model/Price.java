package de.th.koeln.fae.samplemicroservice.order.model;

public class Price {

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

  public Double getValue() {
    return value;
  }
}
