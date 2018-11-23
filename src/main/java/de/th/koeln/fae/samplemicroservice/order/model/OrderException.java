package de.th.koeln.fae.samplemicroservice.order.model;

public class OrderException extends Exception {

  public OrderException(String errorMessage) {
    super(errorMessage);
  }
}
