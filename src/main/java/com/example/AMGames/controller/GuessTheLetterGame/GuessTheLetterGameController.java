package com.example.AMGames.controller.GuessTheLetterGame;

import com.example.AMGames.games.GuessTheLetter.service.GameService;
import com.example.AMGames.util.AttributeNames;
import com.example.AMGames.util.GameMappings;
import com.example.AMGames.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GuessTheLetterGameController {

    private final GameService gameService;

    @Autowired
    public GuessTheLetterGameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(GameMappings.GUESS_THE_LETTER)
    public String getGamePage(){
        return ViewNames.GUESS_THE_LETTER_GAME;
    }

    @GetMapping(GameMappings.PLAY_GUESS_THE_LETTER_GAME)
    public String play(Model model){
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("model {}", model);
        return ViewNames.PLAY_GUESS_THE_LETTER_GAME;
    }

    @PostMapping(GameMappings.PLAY_GUESS_THE_LETTER_GAME)
    public String processMessage(@RequestParam String guess){
        log.info("guess {}", guess);
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;

    }

}
