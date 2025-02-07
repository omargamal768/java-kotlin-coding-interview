package org.example;

import org.example.enums.Move;
import org.example.enums.Result;

public class Game {

    // This method evaluates the result of a round based on the player's moves.
    // Returns WIN if Player A wins, LOSE if Player B wins, and DRAW if it's a tie.
    public Result play(Move playerAMove, Move playerBMove) {
        // If both players make the same move, it's a draw
        if (playerAMove == playerBMove) {
            return Result.DRAW;
        }

        // Player A wins conditions
        if ((playerAMove == Move.ROCK && playerBMove == Move.SCISSORS) ||
                (playerAMove == Move.PAPER && playerBMove == Move.ROCK) ||
                (playerAMove == Move.SCISSORS && playerBMove == Move.PAPER)) {
            return Result.WIN;
        }

        // If not a win or draw, Player B wins
        return Result.LOSE;
    }
}
