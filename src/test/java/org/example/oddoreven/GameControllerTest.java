package org.example.oddoreven;

import org.example.oddoreven.Controller.GameController;
import org.example.oddoreven.Service.OddOrEvenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GameControllerTest {

    @Mock
    private OddOrEvenService oddOrEvenService;

    @Mock
    private Model model;

    @InjectMocks
    private GameController gameController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowRandomNumber() {
        when(oddOrEvenService.generateRandomNumber()).thenReturn(42);

        String viewName = gameController.showRandomNumber(model);

        verify(model).addAttribute("randomNumber", 42);
        assertEquals("index", viewName);
    }

    @Test
    void testPlayOddOrEvenWithCorrectGuess() {
        when(oddOrEvenService.checkOddOrEven("even")).thenReturn("Correct! Well done!");

        String viewName = gameController.playOddOrEven("even", model);

        verify(model).addAttribute("result", "Correct! Well done!");
        assertEquals("result", viewName);
    }

    @Test
    void testPlayOddOrEvenWithWrongGuess() {
        when(oddOrEvenService.checkOddOrEven("odd")).thenReturn("Not correct, please try again!");

        String viewName = gameController.playOddOrEven("odd", model);

        verify(model).addAttribute("result", "Not correct, please try again!");
        assertEquals("result", viewName);
    }
}