package com.premit.netbanking_api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BankAccountDTO {
    @NotNull
    private long accountNumber;
    @NotNull
    private String accountHolderName;
    @NotNull
    private String accountType;
    @NotNull
    private float accountBalance;
}

