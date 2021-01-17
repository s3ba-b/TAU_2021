package com.example.accessingneo4jdatarest;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;

import java.lang.UnsupportedOperationException;

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
    public void testId()
    {
        Owner owner = mock(Owner.class);
        given(owner.getId()).willReturn(69L);
        assertEquals((long) owner.getId(), 69);
    }

    @Test
    public void testGetNameReturnsNull()
    {
        Owner owner = mock(Owner.class);
        when(owner.getName()).thenReturn(null);
        assertEquals(owner.getName(), null);
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