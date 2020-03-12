package org.delivery.repository;

import org.delivery.model.Checkout;
import org.springframework.data.repository.CrudRepository;

public interface CheckoutRepository extends CrudRepository<Checkout, Long> {
}
