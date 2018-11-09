package de.th.koeln.fae.samplemicroservice.person.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import de.th.koeln.fae.samplemicroservice.person.model.Person;

@Repository
@Transactional(readOnly = true)
public class CustomPersonRepositoryImpl implements CustomPersonRepository {


  private static final Logger LOGGER = LoggerFactory.getLogger(CustomPersonRepositoryImpl.class);
  private final EntityManager entityManager;

  @Autowired
  public CustomPersonRepositoryImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Iterable<Person> findAllByAge(Integer age) {
    LOGGER.info("Search for Person with age: " + age);
    final Query query = entityManager
        .createNativeQuery("SELECT p.* FROM PERSON as p WHERE p.AGE=?1", Person.class);
    query.setParameter(1, age);
    return query.getResultList();
  }

}
