package de.th.koeln.fae.samplemicroservice.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import de.th.koeln.fae.samplemicroservice.order.model.LineItem;

@Repository
@RepositoryRestResource(exported = false)
public interface LineItemRepository extends CrudRepository<LineItem, Long> {

}
