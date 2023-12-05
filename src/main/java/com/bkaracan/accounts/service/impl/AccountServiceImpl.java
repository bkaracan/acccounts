package com.bkaracan.accounts.service.impl;

import com.bkaracan.accounts.constant.AccountConstant;
import com.bkaracan.accounts.dto.AccountDto;
import com.bkaracan.accounts.dto.CustomerDto;
import com.bkaracan.accounts.entity.Account;
import com.bkaracan.accounts.entity.Customer;
import com.bkaracan.accounts.exception.CustomerAlreadyExistsException;
import com.bkaracan.accounts.exception.ResourceNotFoundException;
import com.bkaracan.accounts.mapper.AccountsMapper;
import com.bkaracan.accounts.mapper.CustomerMapper;
import com.bkaracan.accounts.repository.AccountRepository;
import com.bkaracan.accounts.repository.CustomerRepository;
import com.bkaracan.accounts.service.AccountService;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer = CustomerMapper.convertToEntity(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());

        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given mobile number " + customerDto.getMobileNumber());
        }

        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.convertToDto(customer, new CustomerDto());
        customerDto.setAccountDto(AccountsMapper.convertToDto(account, new AccountDto()));
        return customerDto;
    }

    private Account createNewAccount(Customer customer) {

        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstant.SAVINGS);
        newAccount.setBranchAddress(AccountConstant.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        return newAccount;
    }
}
