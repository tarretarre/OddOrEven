package org.example.oddoreven;

import org.example.oddoreven.service.OddOrEvenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OddOrEvenServiceTest {

    private OddOrEvenService oddOrEvenService;

    @BeforeEach
    void setUp() {
        oddOrEvenService = new OddOrEvenService();
    }

    @Test
    void testStartNewGameResetsState() {
        oddOrEvenService.startNewGame();
        assertEquals(0, oddOrEvenService.getCorrectChoices());
        assertEquals(0, oddOrEvenService.getRoundCount());
        assertNotEquals(0, oddOrEvenService.getRandomNumber());
    }

    @Test
    void testGenerateNewRandomNumber() {
        oddOrEvenService.generateNewRandomNumber();
        int firstNumber = oddOrEvenService.getRandomNumber();
        oddOrEvenService.generateNewRandomNumber();
        int secondNumber = oddOrEvenService.getRandomNumber();
        assertNotEquals(firstNumber, secondNumber);
    }

    @Test
    void testCorrectOddChoice() {
        oddOrEvenService.setRandomNumber(3);
        String result = oddOrEvenService.playRound("odd");
        assertTrue(result.isEmpty());
        assertEquals(1, oddOrEvenService.getCorrectChoices());
        assertEquals(1, oddOrEvenService.getRoundCount());
    }

    @Test
    void testWrongEvenChoice() {
        oddOrEvenService.setRandomNumber(3);
        String result = oddOrEvenService.playRound("even");
        assertTrue(result.isEmpty());
        assertEquals(0, oddOrEvenService.getCorrectChoices());
        assertEquals(1, oddOrEvenService.getRoundCount());
    }

    @Test
    void testGameOver() {
        oddOrEvenService.setRoundCount(4);
        oddOrEvenService.setRandomNumber(2);
        String result = oddOrEvenService.playRound("even");
        assertTrue(result.contains("You got 1 right out of 5!"));
        assertTrue(oddOrEvenService.isGameOver());
    }

    @Test
    void testResetGame() {
        oddOrEvenService.setCorrectChoices(3);
        oddOrEvenService.setRoundCount(5);
        oddOrEvenService.resetGame();
        assertEquals(0, oddOrEvenService.getCorrectChoices());
        assertEquals(0, oddOrEvenService.getRoundCount());
    }
}