package org.example.oddoreven.Controller;

import org.example.oddoreven.Service.OddOrEvenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private OddOrEvenService oddOrEvenService;

    @GetMapping("/")
    public String showRandomNumber(Model model) {
        int randomNumber = oddOrEvenService.generateRandomNumber();
        model.addAttribute("randomNumber", randomNumber);
        return "index";
    }

    @GetMapping("/play")
    public String playOddOrEven(@RequestParam("choose") String choose, Model model) {
        String result = oddOrEvenService.checkOddOrEven(choose);
        model.addAttribute("result", result);
        return "result";
    }
}
