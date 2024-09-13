package org.example.oddoreven.service;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Random;

@Data
@Service
public class OddOrEvenService {

    private final Random random = new Random();
    private int randomNumber;
    private int correctChoices = 0;
    private int roundCount = 0;

    public void startNewGame() {
        resetGame();
        generateNewRandomNumber();
    }

    public void generateNewRandomNumber() {
        randomNumber = random.nextInt(100) + 1;
    }

    public String playRound(String choice) {
        boolean isEven = (randomNumber % 2 == 0);
        roundCount++;

        String result = "";
        if ((isEven && choice.equalsIgnoreCase("even")) || (!isEven && choice.equalsIgnoreCase("odd"))) {
            correctChoices++;
        } else {
            System.out.println("Wrong");
        }

        if (isGameOver()) {
            result += " You got " + correctChoices + " right out of 5!";
        } else {
            generateNewRandomNumber();
        }

        return result;
    }

    public boolean isGameOver() {
        return roundCount >= 5;
    }


    public void resetGame() {
        correctChoices = 0;
        roundCount = 0;
    }
}