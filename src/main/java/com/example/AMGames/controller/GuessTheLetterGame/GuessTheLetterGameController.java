package com.example.AMGames.controller.GuessTheLetterGame;

import com.example.AMGames.util.GameMappings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuessTheLetterGameController {

    @GetMapping(GameMappings.GUESSTHELETTER)
    public String getGamePage(){
        return "guessTheLetterGame";
    }
}
