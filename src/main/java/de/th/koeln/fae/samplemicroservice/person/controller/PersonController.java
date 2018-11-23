package de.th.koeln.fae.samplemicroservice.person.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import de.th.koeln.fae.samplemicroservice.person.model.Person;
import de.th.koeln.fae.samplemicroservice.person.repository.PersonRepository;

@RepositoryRestController
public class PersonController {

  private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

  private final PersonRepository personRepository;

  @Autowired
  public PersonController(
      PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @GetMapping(path = "/customers")
  public   ResponseEntity<?> getPersons(){
    final Iterable<Person> personList = this.personRepository.findAll();

    Resources<Person> resources = new Resources<>(personList);

    resources.add(linkTo(methodOn(PersonController.class).getPersons()).withSelfRel());

    LOGGER.info("RETURN ALL PERSONS!");
    return  ResponseEntity.ok(resources);
  }

}
