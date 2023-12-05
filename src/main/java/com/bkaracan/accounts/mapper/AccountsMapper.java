package com.bkaracan.accounts.mapper;

import com.bkaracan.accounts.dto.AccountDto;
import com.bkaracan.accounts.entity.Account;

public class AccountsMapper {

    public static AccountDto convertToDto(Account account, AccountDto accountDto) {
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;
    }

    public static Account convertToEntity(AccountDto accountDto, Account account) {
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }
}
