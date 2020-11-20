package com.example.demo;

import com.example.demo.api.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @Test
    void getAnswer() {
        try {
            assertEquals(26, Double.parseDouble(CalculatorService.getAnswer("5,*,5,-,3,+,4,").getAnswer()));
            assertEquals(-24, Double.parseDouble(CalculatorService.getAnswer("-5,*,5,-,3,+,4,").getAnswer()));
            assertEquals("5", CalculatorService.getAnswer("5,").getAnswer());
            assertEquals("MATH ERROR", CalculatorService.getAnswer("-5,/,0,-,3,+,4,").getAnswer());
            assertTrue(CalculatorService.getAnswer("-5,/,0,-,3,+,4,").isError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
