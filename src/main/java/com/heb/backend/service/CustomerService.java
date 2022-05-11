package com.heb.backend.service;

import com.heb.backend.entity.Customer;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerService {
  public void validateCustomer(Customer customer) throws Exception{
    validateEmail(customer.getEmail());

    if(customer.getFirstName().isEmpty()){
      throw new Exception("First name cannot be empty");
    }

    if(customer.getLastName().isEmpty()){
      throw new Exception("Last name cannot be empty");
    }

    if(customer.getEmail().isEmpty()){
      throw new Exception("Email cannot be empty");
    }

    if(customer.getAddress().isEmpty()){
      throw new Exception("Address cannot be empty");
    }

    if(customer.getState().isEmpty()){
      throw new Exception("State cannot be empty");
    }

    if(customer.getCity().isEmpty()){
      throw new Exception("City cannot be empty");
    }

    if (customer.getZipCode() == 0){
      throw new Exception("zipcode cannot be 0");
    }


  }

  private void validateEmail(String email) throws Exception{
    String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    Pattern pattern = Pattern.compile(regexPattern);

    Matcher matcher = pattern.matcher(email);
    if(!matcher.matches()){
      throw new Exception("Email is not in correct format");
    }
  }

  public Customer cleanCustomerData(Customer customer){
    customer.setFirstName(customer.getFirstName().trim());
    customer.setLastName(customer.getLastName().trim());
    customer.setEmail(customer.getEmail().trim());
    customer.setAddress(customer.getAddress().trim());
    customer.setState(customer.getState().trim());
    customer.setCity(customer.getCity().trim());
    return customer;
  }

}
