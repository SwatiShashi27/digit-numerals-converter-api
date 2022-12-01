package com.example.digitnumeralsconverterapi.util;

import com.example.digitnumeralsconverterapi.model.DigitRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ConverterUtil {
    public String convertToNumerals(int digit) {
        final int[] digitsList = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        final String[] romanValues = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder numerals=new StringBuilder();
        for(int i=0;i<digitsList.length;i++)
        {
            while(digit >= digitsList[i])
            {
                digit=digit-digitsList[i];
                numerals.append(romanValues[i]);
            }
        }
        System.out.println("Corresponding Roman Numerals is: " +numerals.toString());
        return numerals.toString();
    }

    public int convertToDigit(String numeral) {

        Map<Character,Integer> mapping=new HashMap<Character,Integer>();

        mapping.put('I',1);
        mapping.put('V',5);
        mapping.put('X',10);
        mapping.put('L',50);
        mapping.put('C',100);
        mapping.put('D',500);
        mapping.put('M',1000);

        numeral = numeral.replace("IV","IIII");
        numeral = numeral.replace("IX","VIIII");
        numeral = numeral.replace("XL","XXXX");
        numeral = numeral.replace("XC","LXXXX");
        numeral = numeral.replace("CD","CCCC");
        numeral = numeral.replace("CM","DCCCC");

        int number = 0;
        for (int i = 0; i < numeral.length(); i++)
        {
            number = number + (mapping.get(numeral.charAt(i)));
        }
        System.out.println(number);
        return number;
    }
}
