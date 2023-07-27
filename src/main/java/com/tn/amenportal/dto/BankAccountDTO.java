package com.tn.amenportal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTO {
    private String rib;
    private String userEmail;
    private String iban;
    private String description;
    private Double balance;
}
