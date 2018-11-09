package de.th.koeln.fae.samplemicroservice.order.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.th.koeln.fae.samplemicroservice.core.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "table_order")
public class Order extends AbstractEntity {

  @Embedded
  @Setter
  private PersonId personId;

  @OneToMany(mappedBy = "order")
  private List<LineItem> lineItems;


  public void addLineItem(LineItem lineItem){
    if (lineItems == null || lineItems.isEmpty()){
      this.lineItems = new ArrayList<>();
    }
    if (lineItem != null) {
      this.lineItems.add(lineItem);
    }else {
      throw new IllegalArgumentException("This line-item is not valid.");
    }
  }

}
