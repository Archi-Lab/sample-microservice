package de.th.koeln.fae.samplemicroservice.person.model;

import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {


  private final String value;

  public Name() {
    this.value = null;
  }

  public Name(String name) {
    Pattern pattern = Pattern.compile("[A-Z]*", Pattern.CASE_INSENSITIVE);
    if (name.length() >= 1 && pattern.matcher(name).find()) {
      this.value = name;
    } else {
      throw new IllegalArgumentException(
          "Name should be longer than 1 character and can not contain any special chars.");
    }
  }

  public String getValue() {
    return value;
  }
}
