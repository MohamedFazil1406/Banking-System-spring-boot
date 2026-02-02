package com.example.Bank.service;

import com.example.Bank.model.Account;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {

    public boolean deposit(Account account, double amount){
        if(amount < 0){
            System.out.println("Amount is negative");
            return false;
        }
        double currentBal=account.getBalance();
        account.setBalance(currentBal+amount);
        System.out.println("Deposited SuccessFully:"+amount);
        return true;

    }

    public boolean withdraw(Account account, double amount){
        if(amount < 0){
            System.out.println("Amount is negative");
            return false;
        }
        double currentBal=account.getBalance();
        account.setBalance(currentBal-amount);
        System.out.println("Withdrawe SuccessFully:"+amount);
        return true;
    }

    public double checkBalance(Account account){
        return account.getBalance();
    }

}
