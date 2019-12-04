package io.pivotal.demo.geode.client.repository;

import io.pivotal.demo.geode.client.model.Customer;
import org.springframework.data.gemfire.repository.GemfireRepository;

public interface CustomerRepository extends GemfireRepository<Customer, String> {

}