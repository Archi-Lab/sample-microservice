package de.th.koeln.fae.samplemicroservice.person.controller;

import org.springframework.data.rest.core.config.Projection;

import de.th.koeln.fae.samplemicroservice.person.model.Name;
import de.th.koeln.fae.samplemicroservice.person.model.Person;

@Projection(name = "nameProjection", types = {Person.class})
public interface NameProjection {
    Name getForename();
    Name getSurname();
}
