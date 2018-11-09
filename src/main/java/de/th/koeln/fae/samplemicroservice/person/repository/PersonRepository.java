package de.th.koeln.fae.samplemicroservice.person.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import de.th.koeln.fae.samplemicroservice.person.controller.NameProjection;
import de.th.koeln.fae.samplemicroservice.person.model.Age;
import de.th.koeln.fae.samplemicroservice.person.model.Person;


@RepositoryRestResource(excerptProjection = NameProjection.class, path = "customers")
public interface PersonRepository extends CrudRepository<Person, Long> {

  Iterable<Person> findAllByAge(Age age);

}
