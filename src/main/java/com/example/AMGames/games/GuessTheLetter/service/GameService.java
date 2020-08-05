package com.example.AMGames.games.GuessTheLetter.service;

public interface GameService {

    String getMainMessage();
    String getResultMessage();
    void checkGuess(String guess);
    boolean isGameWon();
}
