package org.example.oddoreven;

import org.example.oddoreven.Service.OddOrEvenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddOrEvenTest {

    private OddOrEvenService oddOrEvenService;

    @BeforeEach
    void setUp() {
        oddOrEvenService = new OddOrEvenService();
    }

    @Test
    void testGenerateRandomNumber() {
        int randomNumber = oddOrEvenService.generateRandomNumber();
        assertTrue(randomNumber >= 1 && randomNumber <= 100, "Random number should be between 1 and 100");
    }

    @Test
    void testCheckOddOrEvenWithEvenNumber() {
        oddOrEvenService.generateRandomNumber();
        oddOrEvenService.randomNumber = 2;
        String result = oddOrEvenService.checkOddOrEven("even");
        assertEquals("Correct! Well done!", result);
    }

    @Test
    void testCheckOddOrEvenWithOddNumber() {
        oddOrEvenService.generateRandomNumber();
        oddOrEvenService.randomNumber = 3;
        String result = oddOrEvenService.checkOddOrEven("odd");
        assertEquals("Correct! Well done!", result);
    }

    @Test
    void testCheckOddOrEvenWithWrongGuess() {
        oddOrEvenService.generateRandomNumber();
        oddOrEvenService.randomNumber = 4;
        String result = oddOrEvenService.checkOddOrEven("odd");
        assertEquals("Not correct, please try again!", result);
    }
}