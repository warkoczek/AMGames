package com.example.AMGames.config;

import com.example.AMGames.games.GuessTheLetter.GuessCount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.example")
@PropertySource("classpath:config/guessTheLetterGame.properties")
public class GuessTheLetterGameConfig {

    @Value("5")
    private int guessCount;

    @Bean
    @GuessCount
    public int guessCount(){ return guessCount;}

}
