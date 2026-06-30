package com.premit.netbanking_api.dto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="bank_acc")
public class BankAccountEntity {

    @SequenceGenerator(name="bank_acc_seq_gen",
                       sequenceName = "bank_acc_seq",
                       allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bank_acc_seq_gen")
    @Column(name="b_id")
    private int bankId;

    @Column(name="acc_number")
    private long accountNumber;

    @Column(name="acc_holder_name")
    private String accountHolderName;

    @Column(name="acc_type")
    private String accountType;

    @Column(name="bal")
    private float accountBalance;
}

