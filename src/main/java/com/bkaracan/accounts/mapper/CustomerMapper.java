package com.bkaracan.accounts.mapper;

import com.bkaracan.accounts.dto.CustomerDto;
import com.bkaracan.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto convertToDto(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer convertToEntity(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
