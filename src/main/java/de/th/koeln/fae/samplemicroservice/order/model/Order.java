package de.th.koeln.fae.samplemicroservice.order.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import de.th.koeln.fae.samplemicroservice.core.AbstractEntity;
import de.th.koeln.fae.samplemicroservice.person.model.Person;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "table_order")
@AllArgsConstructor
@Getter
@Setter(AccessLevel.NONE)
public class Order extends AbstractEntity {


  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person customer;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "order_id")
  private List<LineItem> lineItems;

  public Order() {
    customer = null;
    lineItems = null;
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

}
