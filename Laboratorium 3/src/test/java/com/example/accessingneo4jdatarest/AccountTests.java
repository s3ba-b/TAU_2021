package com.example.accessingneo4jdatarest;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;

public class AccountTests {

    private Account account;

    @Test
    void AccountNumberIsNull() {
        account = new Account();
        assertNull(account.getAccountNumber());
    }

    @Test
    void AccountNumberIsNotNull() {
        account = new Account(001L, new Owner(), Currency.EUR);
        assertNotNull(account.getAccountNumber());
    }

    @Test
    void AccountNumberEquals001() {
        account = new Account(001L, new Owner(), Currency.EUR);
        long number = account.getAccountNumber();
        assertEquals(number, 001L);
    }

    @Test
    void AccountOwnerIsNotNull() {
        account = new Account(001L, new Owner(), Currency.EUR);
        assertNotNull(account.getAccountOwner());
    }

    @Test
    void AccountOwnerIsNull() {
        account = new Account();
        assertNull(account.getAccountOwner());
    }

    @Test
    void AccountOwnerIsSebastianBobrowski() {
        account = new Account(001L, new Owner("Sebastian", "Bobrowski"), Currency.EUR);
        assertEquals(account.getAccountOwner().getName(), "Sebastian");
        assertEquals(account.getAccountOwner().getSurname(), "Bobrowski");
    }

    @Test
    void AccountCurrencyIsEUR() {
        account = new Account(001L, new Owner(), Currency.EUR);
        assertEquals(account.getAccountCurrency(), Currency.EUR);
    }

    @Test
    void AccountCurrencyIsGBP() {
        account = new Account(001L, new Owner(), Currency.GBP);
        assertEquals(account.getAccountCurrency(), Currency.GBP);
    }

}
