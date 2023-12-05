package com.bkaracan.accounts.service;

import com.bkaracan.accounts.dto.CustomerDto;

public interface AccountService {

    void createAccount(CustomerDto customerDto);
}
