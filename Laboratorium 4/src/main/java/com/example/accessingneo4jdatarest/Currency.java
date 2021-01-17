package com.example.accessingneo4jdatarest;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public enum Currency implements Answer<Object> {
    EUR, PLN, USD, GBP;

    @Override
    public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
        return EUR;
    }
}
