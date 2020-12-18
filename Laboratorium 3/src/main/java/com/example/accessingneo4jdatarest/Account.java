package com.example.accessingneo4jdatarest;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
public class Account {

    @Id
    @GeneratedValue
    private Long accountNumber;

    private Owner accountOwner;

    private Currency accountCurrency;

    public Account(Long accountNumber, Owner accountOwner, Currency accountCurrency) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.accountCurrency = accountCurrency;
    }

    public Account() {
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Owner getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(Owner accountOwner) {
        this.accountOwner = accountOwner;
    }

    public Currency getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(Currency accountCurrency) {
        this.accountCurrency = accountCurrency;
    }
}
