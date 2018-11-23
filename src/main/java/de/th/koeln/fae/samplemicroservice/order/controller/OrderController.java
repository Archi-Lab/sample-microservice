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

import java.util.Optional;

import de.th.koeln.fae.samplemicroservice.order.model.Order;
import de.th.koeln.fae.samplemicroservice.order.model.OrderException;
import de.th.koeln.fae.samplemicroservice.order.model.OrderStatus;
import de.th.koeln.fae.samplemicroservice.order.repository.OrderRepository;

@RepositoryRestController
public class OrderController {

  private final OrderRepository orderRepository;

  @Autowired
  public OrderController(
      OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @PostMapping(path = "/orders/{id}/pay")
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

  @PostMapping(path = "/orders/{id}/cancel")
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
