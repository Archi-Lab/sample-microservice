package de.th.koeln.fae.samplemicroservice.person.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.th.koeln.fae.samplemicroservice.person.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

  Iterable<Person> findAllByAge(int age);

}
