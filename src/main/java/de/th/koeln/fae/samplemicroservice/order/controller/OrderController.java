package de.th.koeln.fae.samplemicroservice.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

import de.th.koeln.fae.samplemicroservice.order.model.Order;
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
