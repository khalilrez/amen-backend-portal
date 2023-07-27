package com.tn.amenportal.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(unique = true , nullable = false)
    private String rib;

    @Column(unique = true , nullable = false)
    private String iban;

    private String description;
    private Double balance;

    private boolean isDisabled;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;
}
