package com.tn.amenportal.models;

import com.tn.amenportal.enums.TransferType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transfers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferId;
    private Date date;
    private Double amount;
    private TransferType transferType;

    @OneToOne(cascade = CascadeType.REMOVE)
    private BankAccount fromAccount;

    @OneToOne(cascade = CascadeType.REMOVE)
    private BankAccount toAccount;
}
