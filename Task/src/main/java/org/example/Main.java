package org.example;

import org.example.enums.Move;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        int playerAWins = 0;
        int playerBWins = 0;
        int draws = 0;
        int totalRounds = 100;

        for (int i = 0; i < totalRounds; i++) {
            Move playerAMove = Move.ROCK;
            Move playerBMove = Move.getRandomMove();

            switch (game.play(playerAMove, playerBMove)) {
                case WIN -> playerAWins++;
                case LOSE -> playerBWins++;
                case DRAW -> draws++;
            }
        }

        System.out.println("Player A wins " + playerAWins + " of " + totalRounds + " games");
        System.out.println("Player B wins " + playerBWins + " of " + totalRounds + " games");
        System.out.println("Draws: " + draws + " of " + totalRounds + " games");
    }



}