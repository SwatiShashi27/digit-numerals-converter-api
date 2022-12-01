package com.example.digitnumeralsconverterapi.controller;

import com.example.digitnumeralsconverterapi.util.ConverterUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ConverterControllerTest {

    @InjectMocks
    private ConverterController converterController;

    @Mock
    private ConverterUtil converterUtil;

    @Test
    public void testConvertToNumerals(){
        when(converterUtil.convertToNumerals(9)).thenReturn("IX");
        String numerals = converterController.digitConverter(9);
        Assertions.assertEquals("IX", numerals);
    }

    @Test
    public void testConvertToDigits(){
        when(converterUtil.convertToDigit("IX")).thenReturn(9);
        int digit = converterController.numeralsConverter("IX");
        Assertions.assertEquals(9, digit);
    }

   /* @Test (expected=NumberFormatException.class)
    public void testConvertToNumeralsException(){
        when(converterUtil.convertToNumerals(-1)).thenThrow();
        //String numerals = converterController.digitConverter(9);
        //Assertions.assertEquals("IX", numerals);
    }*/
}
