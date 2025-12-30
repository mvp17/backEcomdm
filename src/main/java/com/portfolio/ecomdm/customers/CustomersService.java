package com.portfolio.ecomdm.customers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersService {
    public CustomersService() {}

    public List<CustomerDTO> getCustomers() {
        ArrayList<CustomerDTO> customers = new ArrayList<>();
        CustomerDTO customer1 = new CustomerDTO("John", "john@mail.com", 14);
        customers.add(customer1);
        CustomerDTO customer2 = new CustomerDTO("Emily", "emily@mail.com", 15);
        customers.add(customer2);
        CustomerDTO customer3 = new CustomerDTO("Olivia", "oli@mail.com", 25);
        customers.add(customer3);
        CustomerDTO customer4 = new CustomerDTO("Frank", "frank@mail.com", 30);
        customers.add(customer4);

        return customers;
    }
}
