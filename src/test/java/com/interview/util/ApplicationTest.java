package com.interview.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {


    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd() {
        Mockito.doThrow(new RuntimeException("Add operation not implemented")).when(calcService).add(10.0, 20.0);
    }

    @Test
    public void throwEx() {
        Mockito.doThrow(new IllegalArgumentException("Hello ..")).when(calcService).throwEx();
    }
}