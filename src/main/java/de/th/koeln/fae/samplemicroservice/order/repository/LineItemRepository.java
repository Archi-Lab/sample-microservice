package de.th.koeln.fae.samplemicroservice.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.th.koeln.fae.samplemicroservice.order.model.LineItem;

@Repository

public interface LineItemRepository extends CrudRepository<LineItem, Long> {

}
