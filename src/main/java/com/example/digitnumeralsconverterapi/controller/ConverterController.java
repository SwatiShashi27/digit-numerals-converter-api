package com.example.digitnumeralsconverterapi.controller;

import com.example.digitnumeralsconverterapi.exception.ConvertedNumberFormatException;
import com.example.digitnumeralsconverterapi.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConverterController {
    @Autowired
    private ConverterUtil converterUtil;

    @RequestMapping(value = "/digitToNumerals", method = { RequestMethod.GET, RequestMethod.POST })
    public String digitConverter(@RequestParam(value = "digit", defaultValue = "-1") Integer digit) {

        if (digit < 1 || digit > 4000) {
            System.out.println("Invalid roman number value!");
            throw new ConvertedNumberFormatException();
        }

        String numeral = converterUtil.convertToNumerals(digit);
        return numeral;
    }

    @RequestMapping(value = "/numeralsToDigit", method = { RequestMethod.GET, RequestMethod.POST })
    public int numeralsConverter(@RequestParam(value = "numeral", defaultValue = "MCMXV") String numeral) {

        int digit = converterUtil.convertToDigit(numeral);
        if(digit < 1 || digit > 4000){
            System.out.println("Invalid roman number value!");
            throw new ConvertedNumberFormatException();
        }
        return digit;
    }
}
