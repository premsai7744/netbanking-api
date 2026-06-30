package com.premit.netbanking_api.service;

import com.premit.netbanking_api.dto.BankAccountDTO;

public interface NetBankingService {
    public abstract String createBankAccount(BankAccountDTO bankAccountDTO);
    public abstract String updateBankAccount(long accountNumber,String accountType);
}
