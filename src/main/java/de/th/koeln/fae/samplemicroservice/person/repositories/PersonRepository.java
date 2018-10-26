package de.th.koeln.fae.samplemicroservice.person.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.th.koeln.fae.samplemicroservice.person.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

  Iterable<Person> findAllByAge(int age);

}
