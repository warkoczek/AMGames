package com.example.AMGames.games.GuessTheLetter.service;

import com.example.AMGames.games.GuessTheLetter.GuessTheLetterGame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Slf4j
@Service
public class GameServiceImpl implements GameService{

    private final GuessTheLetterGame guessTheLetterGame;

    public GameServiceImpl(GuessTheLetterGame guessTheLetterGame) {
        this.guessTheLetterGame = guessTheLetterGame;
    }

    @PostConstruct
    public void init() {
        log.info("The letter is = {}", guessTheLetterGame.getLetter());
    }

    @Override
    public boolean isGameWon() {
        return false;
    }
}
