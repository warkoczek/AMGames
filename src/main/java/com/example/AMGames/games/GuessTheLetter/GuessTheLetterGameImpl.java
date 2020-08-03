package com.example.AMGames.games.GuessTheLetter;

import com.example.AMGames.games.GuessTheLetter.repository.LetterRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class GuessTheLetterGameImpl implements GuessTheLetterGame {

    private static final int guessCount = 5;
    private final LetterRepository letterRepository;

    private String letter;
    @Getter
    private String guess;

    private boolean validLetter = true;

    @Getter
    private int remainingGuesses;

    public GuessTheLetterGameImpl(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

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

    @Override
    public void check() {
        isValidLetter();
        if(!validLetter) {
            remainingGuesses--;
        }
    }

    private void isValidLetter(){
            validLetter = letterRepository.hasLetter(guess);
    }


    @Override
    public void setGuess(String guess) {
        this.guess = guess.toUpperCase();
    }

    @Override
    public int getGuessCount() {
        return 0;
    }


    @Override
    public boolean isGameLost() {
        return false;
    }

    @Override
    public boolean isGameWon() {
        return false;
    }
}
