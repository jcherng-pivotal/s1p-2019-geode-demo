package io.pivotal.demo.geode.function.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.geode.pdx.PdxInstance;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Customer {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    public Customer(PdxInstance pdxInstance) {
        this.id = (String) pdxInstance.getField("id");
        this.firstName = (String) pdxInstance.getField("firstName");
        this.lastName = (String) pdxInstance.getField("lastName");
        this.dob = (LocalDate) pdxInstance.getField("dob");
    }
}