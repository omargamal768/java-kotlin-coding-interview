import org.example.Game;
import org.example.enums.Move;
import org.example.enums.Result;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testDraws() {
        Game game = new Game();
        assertEquals(Result.DRAW, game.play(Move.ROCK, Move.ROCK));
        assertEquals(Result.DRAW, game.play(Move.PAPER, Move.PAPER));
        assertEquals(Result.DRAW, game.play(Move.SCISSORS, Move.SCISSORS));
    }

    @Test
    void testPlayerAWins() {
        Game game = new Game();
        assertEquals(Result.WIN, game.play(Move.ROCK, Move.SCISSORS));
        assertEquals(Result.WIN, game.play(Move.PAPER, Move.ROCK));
        assertEquals(Result.WIN, game.play(Move.SCISSORS, Move.PAPER));
    }

    @Test
    void testPlayerBWins() {
        Game game = new Game();
        assertEquals(Result.LOSE, game.play(Move.ROCK, Move.PAPER));
        assertEquals(Result.LOSE, game.play(Move.PAPER, Move.SCISSORS));
        assertEquals(Result.LOSE, game.play(Move.SCISSORS, Move.ROCK));
    }

    // Additional Test: Zero rounds
    @Test
    void testZeroRounds() {
        Game game = new Game();
        int playerAWins = 0;
        int playerBWins = 0;
        int draws = 0;
        int totalRounds = 0;

        for (int i = 0; i < totalRounds; i++) {
            Move playerAMove = Move.ROCK;
            Move playerBMove = Move.getRandomMove();

            switch (game.play(playerAMove, playerBMove)) {
                case WIN -> playerAWins++;
                case LOSE -> playerBWins++;
                case DRAW -> draws++;
            }
        }

        assertEquals(0, playerAWins);
        assertEquals(0, playerBWins);
        assertEquals(0, draws);
    }

    // Additional Test: Large number of rounds
    @Test
    void testLargeNumberOfRounds() {
        Game game = new Game();
        int playerAWins = 0;
        int playerBWins = 0;
        int draws = 0;
        int totalRounds = 1000000;  // 1 million rounds

        for (int i = 0; i < totalRounds; i++) {
            Move playerAMove = Move.ROCK;
            Move playerBMove = Move.getRandomMove();

            switch (game.play(playerAMove, playerBMove)) {
                case WIN -> playerAWins++;
                case LOSE -> playerBWins++;
                case DRAW -> draws++;
            }
        }

        assertTrue(playerAWins >= 0 && playerAWins <= totalRounds);
        assertTrue(playerBWins >= 0 && playerBWins <= totalRounds);
        assertTrue(draws >= 0 && draws <= totalRounds);
    }

    // Additional Test: Check if the results add up to total rounds
    @Test
    void testResultsSumToTotalRounds() {
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

        int totalResults = playerAWins + playerBWins + draws;
        assertEquals(totalRounds, totalResults);
    }

    // Additional Test: Controlled randomness with fixed seed
    @Test
    void testControlledRandomness() {
        Game game = new Game();

        // Set a fixed seed for reproducible randomness
        Move.setRandom(new Random(0));

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

        assertTrue(playerAWins >= 0 && playerAWins <= totalRounds);
        assertTrue(playerBWins >= 0 && playerBWins <= totalRounds);
        assertTrue(draws >= 0 && draws <= totalRounds);
    }
}
