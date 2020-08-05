package com.example.AMGames.games.GuessTheLetter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator {

    private final GuessTheLetterGame game;

    public MessageGeneratorImpl(GuessTheLetterGame game) {
        this.game = game;
    }
    @PostConstruct
    public void init(){
        log.info("game {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Guess a letter from the 26 letters Latin Alphabet";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return "You guessed it. The letter was " + game.getLetter();
        }else if(game.isGameLost()) {
            return "You lost it";
        }else if(!game.isValidLetter()){
            return "Invalid letter. Try again";
        }else{
            return "Try to guess. You have " + game.getRemainingGuesses() + " guesses left";
        }

    }
}
