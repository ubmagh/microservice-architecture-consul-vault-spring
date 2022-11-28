package me.ubmagh.customerservice.web;

import lombok.AllArgsConstructor;
import me.ubmagh.customerservice.dtos.requests.CustomerRequestDTO;
import me.ubmagh.customerservice.dtos.responses.CustomerResponseDTO;
import me.ubmagh.customerservice.exceptions.CustomerNotFoundException;
import me.ubmagh.customerservice.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestApi {

    private CustomerService customerService;


    @GetMapping("/customers")
    public List<CustomerResponseDTO> customersList(){
        return this.customerService.listCustomers();
    }

    @PostMapping("/customers")
    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO) {
        return this.customerService.saveCustomer(customerRequestDTO);
    }

    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id){
        CustomerResponseDTO customer;
        try{
            customer = this.customerService.getCustomer(id);
        }catch ( CustomerNotFoundException exc){
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Customer with id: "+exc.getCustomerId()+" was not found !" );
        }
        return customer;
    }

    @PutMapping("/customers/{id}")
    public CustomerResponseDTO updateCustomer(@PathVariable String id, @RequestBody CustomerRequestDTO customerRequestDTO){
        CustomerResponseDTO customer;
        try{
            customer = this.customerService.updateCustomer( id, customerRequestDTO);
        }catch ( CustomerNotFoundException exc){
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Customer with id: "+exc.getCustomerId()+" was not found !" );
        }
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable String id){
        try{
            this.customerService.deleteCustomer( id);
        }catch ( CustomerNotFoundException exc){
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Customer with id: "+exc.getCustomerId()+" was not found !" );
        }
        return id;
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> exceptionHandler(ResponseStatusException exc){
        return new ResponseEntity<>(exc.getReason(), exc.getStatus() );
    }

}
