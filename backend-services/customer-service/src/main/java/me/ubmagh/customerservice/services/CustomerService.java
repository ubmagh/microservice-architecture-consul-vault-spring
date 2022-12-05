package me.ubmagh.customerservice.services;

import me.ubmagh.customerservice.dtos.requests.CustomerRequestDTO;
import me.ubmagh.customerservice.dtos.responses.CustomerResponseDTO;
import me.ubmagh.customerservice.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO);
    public CustomerResponseDTO getCustomer( String customerId) throws CustomerNotFoundException;
    public CustomerResponseDTO updateCustomer( String customerId, CustomerRequestDTO customerRequestDTO) throws CustomerNotFoundException;
    public void deleteCustomer( String customerId);
    public List<CustomerResponseDTO> listCustomers();
}
