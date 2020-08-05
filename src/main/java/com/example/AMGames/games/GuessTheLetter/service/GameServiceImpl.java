package com.example.AMGames.games.GuessTheLetter.service;

import com.example.AMGames.games.GuessTheLetter.GuessTheLetterGame;
import com.example.AMGames.games.GuessTheLetter.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Slf4j
@Service
public class GameServiceImpl implements GameService{

    private final GuessTheLetterGame guessTheLetterGame;
    private final MessageGenerator messageGenerator;

    public GameServiceImpl(GuessTheLetterGame guessTheLetterGame, MessageGenerator messageGenerator) {
        this.guessTheLetterGame = guessTheLetterGame;
        this.messageGenerator = messageGenerator;
    }

    @PostConstruct
    public void init() {
        log.info("The letter is = {}", guessTheLetterGame.getLetter());
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(String guess) {
        guessTheLetterGame.setGuess(guess);
        guessTheLetterGame.check();
    }

    @Override
    public boolean isGameWon() {
        return false;
    }
}
