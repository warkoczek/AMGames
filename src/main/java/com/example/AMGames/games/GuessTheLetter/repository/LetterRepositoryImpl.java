package com.example.AMGames.games.GuessTheLetter.repository;

import com.example.AMGames.games.GuessTheLetter.model.Letter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Component
public class LetterRepositoryImpl implements LetterRepository {

    private ArrayList<Letter> letters;

    private final Random random = new Random();

    public LetterRepositoryImpl() {
        letters = new ArrayList<Letter>(Arrays.asList(
                new Letter("A"), new Letter("B"), new Letter("C"), new Letter("D"),
                new Letter("E"), new Letter("F"), new Letter("G"), new Letter("H"),
                new Letter("I"), new Letter("J"), new Letter("K"), new Letter("L"),
                new Letter("M"), new Letter("N"), new Letter("O"),
                new Letter("P"), new Letter("Q"), new Letter("R"),
                new Letter("S"), new Letter("T"), new Letter("V"), new Letter("W"),
                new Letter("X"), new Letter("Y"), new Letter("Z")));
    }

    @Override
    public boolean hasLetter(String guess) {
        return letters.stream().filter(letter -> letter.getName().equalsIgnoreCase(guess)).findFirst().isPresent();
    }

    @Override
    public String next() {
        int index = random.nextInt(letters.size());
        return letters.get(index).getName();
    }
}
