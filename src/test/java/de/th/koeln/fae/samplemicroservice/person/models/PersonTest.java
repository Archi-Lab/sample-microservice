package de.th.koeln.fae.samplemicroservice.person.models;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.th.koeln.fae.samplemicroservice.person.model.ContactDetails;
import de.th.koeln.fae.samplemicroservice.person.model.Gender;
import de.th.koeln.fae.samplemicroservice.person.model.Person;
import de.th.koeln.fae.samplemicroservice.person.repository.PersonRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(PersonTest.class);

  @Autowired
  private PersonRepository personRepository;

  @Test
  public void createPersonExpectCreated(){
    final Person person = new Person();

    person.setAge(23);
    person.setGender(Gender.MALE);
    person.setForename("Jann");
    person.setSurname("Deterling");

    final ContactDetails contactDetails = new ContactDetails(email, phoneNumber);
    contactDetails.setEmail("jann.deterling@th-koeln.de");
    contactDetails.setPhoneNumber("02134 / 123456");

    person.setContactDetails(contactDetails);
    LOGGER.info("Person to save:");
    LOGGER.info(person.toString());

    final Person savedPerson = this.personRepository.save(person);

    assertNotNull(savedPerson);
    assertNotNull(savedPerson.getPid());
    assertEquals(person.getAge(), savedPerson.getAge());
    assertEquals(person.getForename(), savedPerson.getForename());
    assertEquals(person.getSurname(), savedPerson.getSurname());
    assertEquals(person.getGender(), savedPerson.getGender());
    assertEquals(person.getContactDetails(), savedPerson.getContactDetails());

    LOGGER.info("Person was save:");
    LOGGER.info(savedPerson.toString());

  }

}
