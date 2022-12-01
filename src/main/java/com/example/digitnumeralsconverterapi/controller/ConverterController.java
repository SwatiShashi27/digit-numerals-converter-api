package com.example.digitnumeralsconverterapi.controller;

import com.example.digitnumeralsconverterapi.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConverterController {
    @Autowired
    private ConverterUtil converterUtil;

    @RequestMapping(value = "/digitToNumerals", method = { RequestMethod.GET, RequestMethod.POST })
    public String digitConverter(@RequestParam(value = "digit", defaultValue = "9") Integer digit) {

        if (digit < 1 || digit > 4000) {
            System.out.println("Invalid roman number value!");
            throw new NumberFormatException("Value of RomanNumeral must be positive and less than or equal to 4000.");
        }

        String numeral = converterUtil.convertToNumerals(digit);
        return numeral;
    }

    @RequestMapping(value = "/numeralsToDigit", method = { RequestMethod.GET, RequestMethod.POST })
    public int numeralsConverter(@RequestParam(value = "numeral", defaultValue = "MCMXV") String numeral) {

        int digit = converterUtil.convertToDigit(numeral);
        if(digit < 1 || digit > 4000){
            System.out.println("Invalid roman number value!");
            throw new NumberFormatException("Value of RomanNumeral must be positive and less than or equal to 4000.");
        }
        return digit;
    }
}
