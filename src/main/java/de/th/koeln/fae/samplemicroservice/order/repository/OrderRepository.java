package de.th.koeln.fae.samplemicroservice.order.repository;

import org.springframework.data.repository.CrudRepository;

import de.th.koeln.fae.samplemicroservice.order.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
