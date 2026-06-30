package com.premit.netbanking_api.controller;

import com.premit.netbanking_api.dto.BankAccountDTO;
import com.premit.netbanking_api.service.NetBankingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NetBankingController {

    @Autowired
    NetBankingService netBankingService;

    //1.Using Annotation
    @PostMapping(path="/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String createBankAccount(@Valid @RequestBody BankAccountDTO bankAccountDTO){
        String responseData = netBankingService.createBankAccount(bankAccountDTO);
        return responseData;
    }

    //2.Using Class
    @PostMapping(path="/register")
    public ResponseEntity<String> registerBankAccount(@Valid @RequestBody BankAccountDTO bankAccountDTO){
        String responseData = netBankingService.createBankAccount(bankAccountDTO);
        ResponseEntity<String> responseEntity = new ResponseEntity<>(responseData,HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping(path="/update/{accountNumber}")
    public ResponseEntity<String> updateBankAccount(@PathVariable long accountNumber,
                                                    @RequestParam String accountType){
        String responseData = netBankingService.updateBankAccount(accountNumber,accountType);
        if(responseData.equalsIgnoreCase("Account updated successfully..")){
            return new ResponseEntity<>(responseData,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseData,HttpStatus.NOT_FOUND);
        }
    }
}
