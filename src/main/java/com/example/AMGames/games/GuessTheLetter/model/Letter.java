package com.example.AMGames.games.GuessTheLetter.model;

import lombok.Data;

@Data
public class Letter {

    private String name;

    public Letter(String name) {
        this.name = name;
    }
}
