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

class OwnerTest {

    private Owner owner;

    @Test
    public void testNameAndSurname() {

        owner = new Owner("Sebastian", "Bobrowski");

        String result = owner.getName() + " " + owner.getSurname();
        assertEquals("Sebastian Bobrowski",result);
        System.out.println("Test1");
    }

    @Test
    public void testOwnerNotNull() {

        owner = new Owner("Sebastian", "Bobrowski");

        assertNotNull(owner);
        System.out.println("Test2");
    }

    @Test
    public void testNewOwnerIsSame() {
        Owner newOwner = owner;
        assertSame(newOwner, owner);
        System.out.println("Test3");
    }
}