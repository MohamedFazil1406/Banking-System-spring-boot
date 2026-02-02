package com.example.Bank.controller;

import com.example.Bank.model.Account;
import com.example.Bank.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        Account savedAccount = accountService.createAccount(account);
        logger.info("Account created successfully: {}", savedAccount);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable long id){
        Optional<Account> account=accountService.findAccountByNumber(id);
        logger.info("Account found successfully "+account);
        return account.map(value->new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts=accountService.findAllAccounts();
        logger.info("the list of all acounts "+accounts);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable long id){
        if(!accountService.findAccountByNumber(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountService.deleteAccount(id);
        logger.info("Account deleted successfully");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
