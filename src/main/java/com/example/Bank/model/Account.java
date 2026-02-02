package com.example.Bank.model;

public class Account {

    private Long accNo;        // ✅ changed
    private String accName;
    private Double balance;    // ✅ changed

    // Default constructor (IMPORTANT for JSON)
    public Account() {
    }

    public Account(Long accNo, String accName, Double balance) {
        this.accNo = accNo;
        this.accName = accName;
        this.balance = balance;
    }

    public Long getAccNo() {
        return accNo;
    }

    public void setAccNo(Long accNo) {
        this.accNo = accNo;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account details:{" + accNo + "," + accName + "," + balance + "}";
    }
}
