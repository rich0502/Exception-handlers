package com.ehd.exceptionhandlers.infrastructure;

import com.ehd.exceptionhandlers.entities.Customer;
import com.ehd.exceptionhandlers.exception.CustomerNotFoundException;
import com.ehd.exceptionhandlers.exception.DupicateCustomerException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    List<Customer> customers = List.of(
            new Customer(UUID.randomUUID().toString(), "Table", "Meuble", 2000.0),
            new Customer(UUID.randomUUID().toString(), "Phone", "Electronics", 500.0),
            new Customer(UUID.randomUUID().toString(), "Ecran", "Computer", 100.0),
            new Customer(UUID.randomUUID().toString(), "clavier", "Computer", 500.0),
            new Customer(UUID.randomUUID().toString(), "Souris", "Computer", 600.0),
            new Customer(UUID.randomUUID().toString(), "Chargeur", "Computer", 700.0)
    );

    @GetMapping("/getCustomersByType/{type}")
    public List<Customer> getCustomersBytype(@PathVariable String type) {
        List<Customer> filter = customers.stream().filter(custom -> custom.getType().equals(type))
                .collect(Collectors.toList());

        return Optional.of(filter)
                .filter(customer -> !customer.isEmpty())
                .orElseThrow(() -> new CustomerNotFoundException("Product not available for the type " + type));
    }

    @PostMapping("/saveCustomer")
    public Customer saveCustomer(@RequestBody Customer ctm) {
        boolean exist = customers.stream().anyMatch(customer -> customer.getId().equals(ctm.getId()));
        if(exist){
            throw new DupicateCustomerException("Customer already exist " + ctm.getId());
        }
        ctm.setId(UUID.randomUUID().toString());
        return ctm;
    }
}
