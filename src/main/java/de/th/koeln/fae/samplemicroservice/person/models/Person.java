package de.th.koeln.fae.samplemicroservice.person.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long pid;

  @Enumerated
  private Gender gender;

  @Embedded
  private ContactDetails contactDetails;

  private String forename;
  private String surname;
  private int age;


  public ContactDetails getContactDetails() {
    return contactDetails;
  }

  public void setContactDetails(
      ContactDetails contactDetails) {
    this.contactDetails = contactDetails;
  }

  public String getForename() {
    return forename;
  }

  public void setForename(String forename) {
    this.forename = forename;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Long getPid() {
    return pid;
  }

  @Override
  public String toString() {
    return "Person{" +
        "pid=" + pid +
        ", gender=" + gender +
        ", contactDetails=" + contactDetails +
        ", forename='" + forename + '\'' +
        ", surname='" + surname + '\'' +
        ", age=" + age +
        '}';
  }
}
