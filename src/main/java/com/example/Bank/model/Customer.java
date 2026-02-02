package com.example.Bank.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long customerId;
    private String customerName;
    private String contactInfo;
    private List<Account> accounts=new ArrayList<>()   ;

    public Customer(long customerId, String customerName, String contactInfo) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactInfo = contactInfo;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccounts(Account account) {
       accounts.add(account);
    }

    @Override
    public String toString() {
        return "Customer Info: {"+customerId+","+customerName+","+contactInfo+","+accounts+"}";
    }
}
