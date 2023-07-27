package com.tn.amenportal.services;

import com.tn.amenportal.dto.BankAccountDTO;
import com.tn.amenportal.exceptions.BankAccountNotFoundException;
import com.tn.amenportal.models.BankAccount;
import com.tn.amenportal.repositories.BankAccountRepo;
import com.tn.amenportal.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepo bankAccountRepo;
    private final UserRepo userRepo;


    public ResponseEntity<BankAccount> createBankAccount(BankAccountDTO request) {
        var user = userRepo.findByEmail(request.getUserEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        BankAccount bankAccount = BankAccount.builder()
                .rib(request.getRib())
                .user(user)
                .iban(request.getIban())
                .description("")
                .balance(0d)
                .build();

        bankAccountRepo.save(bankAccount);

        return ResponseEntity.ok(bankAccount);
    }

    public ResponseEntity<String> toggleBankAccountStatus(String rib) throws BankAccountNotFoundException {
       var bankAccount = bankAccountRepo.findBankAccountByRib(rib).orElseThrow(() -> new BankAccountNotFoundException("RIB doesn't exist"));
       bankAccount.setDisabled(!bankAccount.isDisabled());
       return ResponseEntity.ok("Status Changed");
    }

    public ResponseEntity<BankAccount> updateBankAccount(Long id,BankAccountDTO bankAccountDTO) throws BankAccountNotFoundException {
        var bankAccount = bankAccountRepo.findById(id).orElseThrow(() -> new BankAccountNotFoundException("id doesn't exist"));
        if(bankAccountDTO.getDescription()!= null){
            bankAccount.setDescription(bankAccountDTO.getDescription());
        }

        if (bankAccountDTO.getBalance() != null) {
            bankAccount.setBalance(bankAccountDTO.getBalance());
        }

        bankAccountRepo.save(bankAccount);
        return ResponseEntity.ok(bankAccount);
    }


    public ResponseEntity<BankAccount> findBankById(){
        // TODO: 7/27/2023  Complete searching Functions;
        return null;
    }
}
