package de.th.koeln.fae.samplemicroservice.core;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Abstrakte Klasse einer Entität, durch Vererbung erhält so jede Klasse eine ID.
 * Spart ein paar Zeilen Code pro Entität
 */
@MappedSuperclass
public abstract class AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonIgnore
  private Long id;

  public Long getId() {
    return id;
  }
}
