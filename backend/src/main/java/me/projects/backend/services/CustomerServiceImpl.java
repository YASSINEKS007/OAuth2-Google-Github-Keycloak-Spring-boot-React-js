package me.projects.backend.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import me.projects.backend.entities.Customer;
import me.projects.backend.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;


    @Override
    public Customer createCustomer(Customer product) {
        return customerRepository.save(product);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer oldCustomer = getCustomer(id);
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setName(customer.getName());
        return customerRepository.save(oldCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
