package com.example.Bank.controller;

import com.example.Bank.model.Account;
import com.example.Bank.service.AccountService;
import com.example.Bank.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private static final Logger logger =
            LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    // Deposit
    @PostMapping("/transactions/deposit/{id}")
    public ResponseEntity<String> deposit(
            @PathVariable long id,
            @RequestParam double amount) {

        Optional<Account> account = accountService.findAccountByNumber(id);

        if (!account.isPresent()) {
            logger.error("Deposit failed. Account not found: {}", id);
            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
        }

        boolean success = transactionService.deposit(account.get(), amount);

        if (!success) {
            logger.warn("Deposit failed. Invalid amount: {}", amount);
            return new ResponseEntity<>("Invalid deposit amount", HttpStatus.BAD_REQUEST);
        }

        logger.info("Deposit successful. Amount {} credited to account {}", amount, id);
        return new ResponseEntity<>("Deposit successful", HttpStatus.OK);
    }

    // Withdraw
    @PostMapping("/transactions/withdraw/{id}")
    public ResponseEntity<String> withdraw(
            @PathVariable long id,
            @RequestParam double amount) {

        Optional<Account> account = accountService.findAccountByNumber(id);

        if (!account.isPresent()) {
            logger.error("Withdrawal failed. Account not found: {}", id);
            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
        }

        boolean success = transactionService.withdraw(account.get(), amount);

        if (!success) {
            logger.warn("Withdrawal failed. Invalid amount: {}", amount);
            return new ResponseEntity<>("Invalid withdrawal or insufficient balance",
                    HttpStatus.BAD_REQUEST);
        }

        logger.info("Withdrawal successful. Amount {} debited from account {}", amount, id);
        return new ResponseEntity<>("Withdrawal successful", HttpStatus.OK);
    }

    // Check balance
    @GetMapping("/transactions/balance/{id}")
    public ResponseEntity<Double> checkBalance(@PathVariable long id) {

        Optional<Account> account = accountService.findAccountByNumber(id);

        if (!account.isPresent()) {
            logger.error("Balance check failed. Account not found: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        double balance = transactionService.checkBalance(account.get());
        logger.info("Balance checked for account {} : {}", id, balance);

        return new ResponseEntity<>(balance, HttpStatus.OK);
    }
}
