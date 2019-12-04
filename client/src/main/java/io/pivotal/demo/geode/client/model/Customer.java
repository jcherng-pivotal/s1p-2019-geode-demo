package io.pivotal.demo.geode.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Region("customer")
public class Customer {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private LocalDate dob;
}