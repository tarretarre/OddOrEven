package org.example.oddoreven.controller;

import org.example.oddoreven.service.OddOrEvenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GameController {

    @Autowired
    private OddOrEvenService oddOrEvenService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/start")
    public String startGame(Model model) {
        oddOrEvenService.startNewGame();
        model.addAttribute("randomNumber", oddOrEvenService.getRandomNumber());
        return "play";
    }

    @PostMapping("/play")
    public String gamePlay(@RequestParam("choice") String choice, RedirectAttributes redirectAttributes) {
        String result = oddOrEvenService.playRound(choice);
        redirectAttributes.addFlashAttribute("result", result);

        if (oddOrEvenService.isGameOver()) {
            redirectAttributes.addFlashAttribute("correctChoices", oddOrEvenService.getCorrectChoices());
            return "redirect:/finish";
        }

        redirectAttributes.addFlashAttribute("randomNumber", oddOrEvenService.getRandomNumber());
        return "redirect:/play";
    }

    @GetMapping("/play")
    public String showPlayPage() {
        return "play";
    }

    @GetMapping("/finish")
    public String finishGame(Model model) {
        model.addAttribute("correctChoices", oddOrEvenService.getCorrectChoices());
        return "finish";
    }
}