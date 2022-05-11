package com.heb.backend.controller;

import com.heb.backend.entity.Customer;
import com.heb.backend.repository.CustomerRepository;
import com.heb.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  CustomerService customerService;


  @GetMapping
  public ResponseEntity<List<Customer>> getAllCustomers(){
    try{
      List<Customer> customers = new ArrayList<>();
      customerRepository.findAll().forEach(customers::add);
      if(customers.isEmpty()){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(customers, HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

 @RequestMapping(method = RequestMethod.GET, params = "city")
  public ResponseEntity<List<Customer>> getCustomerByCity(@RequestParam String city){
    List<Customer> customerData = customerRepository.findByCity(city);
    if(!customerData.isEmpty()){
      return new ResponseEntity<>(customerData, HttpStatus.OK);
    } else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
    Optional<Customer> customerData = customerRepository.findById(id);
    if (customerData.isPresent()){
      return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
    } else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
    try{
      customer = customerService.cleanCustomerData(customer);
      customerService.validateCustomer(customer);
      Customer _customer = customerRepository.save(customer);
      return new ResponseEntity<>(_customer, HttpStatus.CREATED);
    } catch (Exception e){
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
