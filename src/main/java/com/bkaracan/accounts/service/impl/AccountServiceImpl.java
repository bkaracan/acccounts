package com.bkaracan.accounts.service.impl;

import com.bkaracan.accounts.dto.AccountDto;
import com.bkaracan.accounts.repository.AccountRepository;
import com.bkaracan.accounts.repository.CustomerRepository;
import com.bkaracan.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(AccountDto accountDto) {


    }
}
