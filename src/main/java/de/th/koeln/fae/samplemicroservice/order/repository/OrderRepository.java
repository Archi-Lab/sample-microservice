package de.th.koeln.fae.samplemicroservice.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import de.th.koeln.fae.samplemicroservice.order.model.Order;

@Repository
@RepositoryRestResource(path = "orders", itemResourceRel = "order", collectionResourceRel = "orders")
public interface OrderRepository extends CrudRepository<Order, Long> {

}
