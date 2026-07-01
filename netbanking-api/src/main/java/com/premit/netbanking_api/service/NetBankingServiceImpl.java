package com.premit.netbanking_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.premit.netbanking_api.dto.BankAccountDTO;
import com.premit.netbanking_api.dto.entity.BankAccountEntity;
import com.premit.netbanking_api.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NetBankingServiceImpl implements NetBankingService{

    @Autowired
    ObjectMapper mapper;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public String createBankAccount(BankAccountDTO bankAccountDTO) {
        BankAccountEntity bankAccountEntity = mapper.convertValue(bankAccountDTO,BankAccountEntity.class);
        bankAccountRepository.save(bankAccountEntity);
        return "Account created successfully, Please login.";
    }

    @Override
    public String updateBankAccount(long accountNumber, String accountType) {
        Optional<BankAccountEntity> optional = bankAccountRepository.findByAccountNumber(accountNumber);
        if(optional.isPresent()){
            BankAccountEntity retrievedBankAccountEntity = optional.get();
            retrievedBankAccountEntity.setAccountType(accountType);
            return "Account updated successfully..";
        } else {
            return "Account not found..";
        }

    }
}
