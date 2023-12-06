package com.bkaracan.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "Schema to hold account information"
)
public class AccountDto {

    @Schema(
            description = "Account number of the bank account"
    )
    @NotEmpty(message = "account number cannot be null or empty value")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of the bank account",
            example = "Savings"
    )
    @NotEmpty(message = "account type cannot be a null or empty value")
    private String accountType;

    @Schema(
            description = "Bank branch address"
    )
    @NotEmpty(message = "branch address cannot be a null or empty value")
    private String branchAddress;
}
