package de.th.koeln.fae.samplemicroservice.order.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import de.th.koeln.fae.samplemicroservice.core.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
public class LineItem extends AbstractEntity {

  @ManyToOne
  @Setter
  private Order order;

  @Enumerated
  private final Item item;

  @Embedded
  private final Amount amount;

  @Embedded
  private final Price price;

  public LineItem(){

    this.item = null;
    this.amount = null;
    this.price = null;
  }
}
