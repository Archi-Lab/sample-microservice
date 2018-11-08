package de.th.koeln.fae.samplemicroservice.person.model;

import javax.persistence.Embeddable;

@Embeddable
public class ContactDetails {

  public ContactDetails(String email, String phoneNumber){

    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  private String email;
  private String phoneNumber;


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }

}
