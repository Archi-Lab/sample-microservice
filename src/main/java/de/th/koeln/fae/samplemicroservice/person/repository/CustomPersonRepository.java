package de.th.koeln.fae.samplemicroservice.person.repository;

import org.springframework.data.repository.query.Param;

import de.th.koeln.fae.samplemicroservice.person.model.Person;

public interface CustomPersonRepository {

  Iterable<Person> findAllByAge(@Param("age") Integer age);

}
