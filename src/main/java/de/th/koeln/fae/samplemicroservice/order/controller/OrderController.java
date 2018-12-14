package de.th.koeln.fae.samplemicroservice.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import de.th.koeln.fae.samplemicroservice.order.model.Order;
import de.th.koeln.fae.samplemicroservice.order.model.OrderException;
import de.th.koeln.fae.samplemicroservice.order.model.OrderStatus;
import de.th.koeln.fae.samplemicroservice.order.repository.OrderRepository;

/**
 * OrderController, stellt eine Restschnittstell für Orders bereit.
 */

@RepositoryRestController /* Sagt Spring Data Rest, dass ein Repository mit dieser Klasse erweitert wird. */
@RequestMapping("/orders") /* Mappt einen Request URI auf die gesamte Klasse.*/
public class OrderController {

  /* Repository Objekt  für die Orders, durch dieses Objekt können die Daten von der Datenbank abgerufen und verändert werden*/
  private final OrderRepository orderRepository;

  /* @Autowired zeigt spring das die Parameter dieses Constructors initialisiert und übergeben werden müssen */
  @Autowired
  public OrderController(
      OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  /* Diese Methode kann auf der URI "/{id}/pay" mit dem HTTP-POST aufgerufen werden.
   * @PathVariable("id") entnimmt der URI den Parameter ID wie oben angegeben, dieser
   * wird in die Variable id gespeichert.
   *
   * */
  @PostMapping(path = "/{id}/pay")
  public ResponseEntity<?> postPay(@PathVariable("id") Long id) {
    final Optional<Order> optionalOrder = this.orderRepository.findById(id);
    if (optionalOrder.isPresent()) {
      final Order order = optionalOrder.get();
      try {
        order.pay();
        this.orderRepository.save(order);
        return ResponseEntity.ok(new Resource<>(order));
      } catch (OrderException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
      }
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping(path = "/{id}/cancel")
  public ResponseEntity<?> postCancel(@PathVariable("id") Long id) {
    final Optional<Order> optionalOrder = this.orderRepository.findById(id);
    if (optionalOrder.isPresent()) {
      final Order order = optionalOrder.get();
      try {
        order.cancel();
        this.orderRepository.save(order);
        return ResponseEntity.ok(new Resource<>(order));
      } catch (OrderException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
      }
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  /*
  * Diese Methode beschreibt wie eine Resource des Types Order zu erweitern.
  * Hierbei werden verschiedene Links an die Resource hinzugefügt.
  * */
  @Bean
  public ResourceProcessor<Resource<Order>> personProcessor() {

    return new ResourceProcessor<Resource<Order>>() {

      @Override
      public Resource<Order> process(Resource<Order> resource) {

        if (resource.getContent().getStatus().equals(OrderStatus.OPEN)) {
          resource
              .add(new Link(resource.getLink(Link.REL_SELF).getHref() + "/pay", "pay"));
          resource.add(new Link(resource.getLink(Link.REL_SELF).getHref() + "/cancel",
              "cancel"));
        }
        return resource;
      }
    };
  }

}
