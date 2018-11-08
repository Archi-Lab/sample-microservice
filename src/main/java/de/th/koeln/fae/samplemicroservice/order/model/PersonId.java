package de.th.koeln.fae.samplemicroservice.order.model;

import javax.persistence.Embeddable;

@Embeddable
public class PersonId {

  private final Long pid;

  PersonId() {
    this.pid = null;
  }

  PersonId(Long pid) {
    this.pid = pid;
  }

  public Long getPid() {
    return pid;
  }
}
