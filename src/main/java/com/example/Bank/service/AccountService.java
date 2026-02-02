package com.example.Bank.service;

import com.example.Bank.model.Account;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final List<Account> accounts= Collections.synchronizedList(new ArrayList<>());

    public Account createAccount(Account account){

        accounts.add(account);
        System.out.println("Created account SuccessFully");
        return account;
    }

    public Optional<Account> findAccountByNumber(long accNo){
    return accounts.stream().filter(account->account.getAccNo().equals(accNo)).findFirst();

    }

    public List<Account> findAllAccounts(){
        return accounts;
    }

    public void deleteAccount(long accNo){
        accounts.removeIf(account -> account.getAccNo() == accNo);
    }


}
