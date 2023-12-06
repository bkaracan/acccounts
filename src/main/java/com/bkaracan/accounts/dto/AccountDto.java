package com.bkaracan.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDto {

    @NotEmpty(message = "account number cannot be null or empty value")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "account type cannot be a null or empty value")
    private String accountType;

    @NotEmpty(message = "branch address cannot be a null or empty value")
    private String branchAddress;
}
