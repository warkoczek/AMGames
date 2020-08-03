package com.example.AMGames.games.GuessTheLetter.repository;

public interface LetterRepository {
    boolean hasLetter(String guess);
    String next();
}
