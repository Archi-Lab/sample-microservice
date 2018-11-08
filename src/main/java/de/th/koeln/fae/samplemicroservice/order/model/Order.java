package de.th.koeln.fae.samplemicroservice.order.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import de.th.koeln.fae.samplemicroservice.core.AbstractEntity;

@Entity
public class Order extends AbstractEntity {

  PersonId personId;

  @ElementCollection
  List<LineItem> lineItems;
}
