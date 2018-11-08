package de.th.koeln.fae.samplemicroservice.order.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Enumerated;

@Embeddable
public class LineItem {

  @Enumerated
  private Item item;

  @Embedded
  private Amount amount;

  @Embedded
  private Price price;
}
