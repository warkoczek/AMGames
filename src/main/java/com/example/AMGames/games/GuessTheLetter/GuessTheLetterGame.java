package com.example.AMGames.games.GuessTheLetter;

public interface GuessTheLetterGame {

    String getLetter();
    String getGuess();
    void reset();
    void check();
    void setGuess(String letter);
    int getRemainingGuesses();
    int getGuessCount();
    boolean isGameLost();
    boolean isGameWon();
}
