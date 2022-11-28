package me.ubmagh.customerservice.mappers;

import me.ubmagh.customerservice.dtos.requests.CustomerRequestDTO;
import me.ubmagh.customerservice.dtos.responses.CustomerResponseDTO;
import me.ubmagh.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDTO customerReqDto);
}
