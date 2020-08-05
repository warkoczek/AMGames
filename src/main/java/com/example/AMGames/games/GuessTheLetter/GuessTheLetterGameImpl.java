package com.example.AMGames.games.GuessTheLetter;

import com.example.AMGames.games.GuessTheLetter.repository.LetterRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Slf4j
@Getter
public class GuessTheLetterGameImpl implements GuessTheLetterGame {


    private final LetterRepository letterRepository;
    private final int guessCount;
    @Autowired
    public GuessTheLetterGameImpl(LetterRepository letterRepository,@GuessCount int guessCount) {
        this.letterRepository = letterRepository;
        this.guessCount = guessCount;
    }

    private String letter;
    @Setter
    private String guess;

    private boolean validLetter = true;

    @Getter
    private int remainingGuesses;


    @Override
    public String getLetter() {
        return letterRepository.next();
    }

    @PostConstruct
    @Override
    public void reset() {
        remainingGuesses = guessCount;
        letter = letterRepository.next();
        log.debug("This is the letter {}", letter);
    }
    @PreDestroy
    public void preDestroy(){
        log.info("In Game preDestroy()");
    }

    @Override
    public void check() {
        validLetter();
        if(!validLetter) {
            remainingGuesses--;
        }
    }

    private void validLetter(){
            validLetter = letterRepository.hasLetter(guess);
    }


    @Override
    public void setGuess(String guess) {
        this.guess = guess;
    }


    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    @Override
    public boolean isGameWon() {
        return guess == letter;
    }
}
