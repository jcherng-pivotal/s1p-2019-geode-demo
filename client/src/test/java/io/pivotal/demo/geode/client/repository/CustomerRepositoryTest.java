package io.pivotal.demo.geode.client.repository;

import io.pivotal.demo.geode.client.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testAdd() {
        Customer customer = Customer
                .builder()
                .id("id1")
                .build();
        Customer actual = customerRepository.save(customer);
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo("id1");
    }
}