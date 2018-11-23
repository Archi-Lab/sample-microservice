package de.th.koeln.fae.samplemicroservice.order.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.th.koeln.fae.samplemicroservice.core.AbstractEntity;
import de.th.koeln.fae.samplemicroservice.person.model.Person;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "table_order")
@Getter
@Setter(AccessLevel.NONE)
public class Order extends AbstractEntity {


  private OrderStatus status;

  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person customer;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "order_id")
  private List<LineItem> lineItems;

  public Order() {
    customer = null;
    lineItems = null;
    status = OrderStatus.OPEN;
  }

  public Order(Person customer, LineItem... lineItems) {
    this.customer = customer;
    this.lineItems = Arrays.asList(lineItems);
    this.status = OrderStatus.OPEN;
  }


  public void addLineItem(LineItem lineItem) {
    if (lineItems == null || lineItems.isEmpty()) {
      this.lineItems = new ArrayList<>();
    }
    if (lineItem != null) {
      this.lineItems.add(lineItem);
    } else {
      throw new IllegalArgumentException("This line-item is not valid.");
    }
  }

  public void addCustomer(Person customer) {
    // DO SOME BUSINESS LOGIC HERE
    this.customer = customer;
  }

  public void markPaid() throws OrderException {
    if (this.status.equals(OrderStatus.OPEN)) {
      this.status = OrderStatus.PAID;
    } else {
      throw new OrderException("Illegal Process, your order is allready paid or cancelled.");
    }
  }

  public void markCancelled() {

  }

}
