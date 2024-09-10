package org.example.oddoreven.Service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OddOrEvenService {

    private final Random random = new Random();
    public int randomNumber;

    public int generateRandomNumber() {
        randomNumber = random.nextInt(100) + 1;
        return randomNumber;
    }

    public String checkOddOrEven(String choose) {
        boolean isEven = (randomNumber % 2 == 0);

        if ((isEven && choose.equalsIgnoreCase("even")) || (!isEven && choose.equalsIgnoreCase("odd"))) {
            return "Correct! Well done!";
        } else {
            return "Not correct, please try again!";
        }
    }
}
