package de.th.koeln.fae.samplemicroservice.person.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import de.th.koeln.fae.samplemicroservice.core.AbstractEntity;

@Entity(name = "person")
public class Person extends AbstractEntity {

  @Enumerated
  private Gender gender;

  @Embedded
  private ContactDetails contactDetails;

  private Name forename;

  private Name surname;

  @Embedded
  private Age age;


  public ContactDetails getContactDetails() {
    return contactDetails;
  }

  public void setContactDetails(
      ContactDetails contactDetails) {
    this.contactDetails = contactDetails;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public void setAge(Age age) {
    this.age = age;
  }

  public Age getAge() {
    return age;
  }

  public Name getForename() {
    return forename;
  }

  public void setForename(Name forename) {
    this.forename = forename;
  }

  public Name getSurname() {
    return surname;
  }

  public void setSurname(Name surname) {
    this.surname = surname;
  }

  @Override
  public String toString() {
    return "Person{" +
        "pid=" + getId() +
        ", gender=" + gender +
        ", contactDetails=" + contactDetails +
        ", forename='" + forename + '\'' +
        ", surname='" + surname + '\'' +
        ", age=" + age +
        '}';
  }


}
