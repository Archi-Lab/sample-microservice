package de.th.koeln.fae.samplemicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import de.th.koeln.fae.samplemicroservice.order.model.Amount;
import de.th.koeln.fae.samplemicroservice.order.model.Item;
import de.th.koeln.fae.samplemicroservice.order.model.LineItem;
import de.th.koeln.fae.samplemicroservice.order.model.Order;
import de.th.koeln.fae.samplemicroservice.order.model.Price;
import de.th.koeln.fae.samplemicroservice.order.repository.OrderRepository;
import de.th.koeln.fae.samplemicroservice.person.model.Age;
import de.th.koeln.fae.samplemicroservice.person.model.ContactDetails;
import de.th.koeln.fae.samplemicroservice.person.model.Gender;
import de.th.koeln.fae.samplemicroservice.person.model.Name;
import de.th.koeln.fae.samplemicroservice.person.model.Person;
import de.th.koeln.fae.samplemicroservice.person.repository.PersonRepository;

/**
 * Sample Date Load, dieser initialisiert den Service mit Beispieldaten. Sollte nur Lokal eingesetzt werden.
 */
@Component /* @Component zeigt Spring, dass diese Klasse gefunden und zur Laufzeit geladen werden muss.*/
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {


  private final PersonRepository personRepository;

  private final OrderRepository orderRepository;

  /* @Autowired zeigt spring das die Parameter dieses Constructors initialisiert und übergeben werden müssen */
  @Autowired
  public SampleDataLoader(
      PersonRepository personRepository,
      OrderRepository orderRepository) {
    this.personRepository = personRepository;
    this.orderRepository = orderRepository;
  }


  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    final Person person = new Person();

    person.setAge(new Age(23));
    person.setGender(Gender.MALE);
    person.setForename(new Name("Jann"));
    person.setSurname(new Name("Deterling"));

    final ContactDetails contactDetails = new ContactDetails("jann.deterling@th-koeln.de",
        "02134 / 123456");

    person.setContactDetails(contactDetails);
    final Person savedPerson = this.personRepository.save(person);

    final Order order = new Order();
    order.addCustomer(savedPerson);
    order.addLineItem(new LineItem(Item.EGG, new Amount(2), new Price(12.0)));
    orderRepository.save(order);
  }
}
