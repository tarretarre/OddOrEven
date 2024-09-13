package org.example.oddoreven;

import org.example.oddoreven.controller.GameController;
import org.example.oddoreven.service.OddOrEvenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(GameController.class)
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OddOrEvenService oddOrEvenService;

    @Test
    void testHome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    void testStartGame() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/start"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("play"));
    }

    @Test
    void testGamePlayCorrectChoice() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/play")
                        .param("choice", "even")) // Example parameter
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("play"));
    }

    @Test
    void testFinishGame() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/finish"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("finish"));
    }
}