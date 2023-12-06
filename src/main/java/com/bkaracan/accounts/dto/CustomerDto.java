package com.bkaracan.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

        @NotEmpty(message = "name cannot be a null or empty value")
        @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
        private String name;

        @NotEmpty(message = "email cannot be a null or empty value")
        @Email(message = "email address must be valid value")
        private String email;

        @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits")
        private String mobileNumber;

        private AccountDto accountDto;
}
