package com.premit.netbanking_api.repository;

import com.premit.netbanking_api.dto.BankAccountDTO;
import com.premit.netbanking_api.dto.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity,Integer> {
    Optional<BankAccountEntity> findByAccountNumber(long accountNumber);
}
