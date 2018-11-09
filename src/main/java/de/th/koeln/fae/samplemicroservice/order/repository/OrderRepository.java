package de.th.koeln.fae.samplemicroservice.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.th.koeln.fae.samplemicroservice.order.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
