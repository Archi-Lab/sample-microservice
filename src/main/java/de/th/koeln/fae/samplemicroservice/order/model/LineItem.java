package de.th.koeln.fae.samplemicroservice.order.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import de.th.koeln.fae.samplemicroservice.core.AbstractEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@Getter
@Access(AccessType.FIELD)
public class LineItem {

  @Enumerated
  private  Item item;

  @Embedded
  private  Amount amount;

  @Embedded
  private  Price price;

  protected LineItem(){

    this.item = null;
    this.amount = null;
    this.price = null;
  }
}
