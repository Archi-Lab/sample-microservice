package de.th.koeln.fae.samplemicroservice.order.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonId {

  @Column(name = "person")
  private final Long pid;

  protected PersonId() {
    this.pid = null;
  }

  public PersonId(Long pid) {
    this.pid = pid;
  }

  public Long getPid() {
    return pid;
  }
}
