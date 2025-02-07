# Rock, Paper, Scissors Game

## Description

This is a simple implementation of the classic game **Rock, Paper, Scissors**, where:

- Player A always plays **Rock**.
- Player B plays randomly, either **Rock**, **Paper**, or **Scissors**.

The game is played for a total of **100 rounds**. After each round, the result is evaluated as one of the following:
- **WIN**: Player A wins the round.
- **LOSE**: Player B wins the round.
- **DRAW**: Both players play the same move, resulting in a draw.

The program keeps track of the number of wins for each player and the number of draws. At the end of the 100 rounds, the results are displayed.

### Game Rules
- **Rock** beats **Scissors**.
- **Scissors** beats **Paper**.
- **Paper** beats **Rock**.
- If both players make the same move, it's a **Draw**.

## Features

1. **Game Logic**:
    - The game logic is encapsulated in the `Game` class, which determines the outcome of each round.

2. **Random Player B**:
    - Player B's moves are selected randomly using a random number generator.

3. **Rock Player A**:
    - Player A always chooses **Rock**.

4. **Round Evaluation**:
    - The result of each round (win, loss, or draw) is determined by comparing Player A’s move (always **Rock**) with Player B's randomly chosen move.

5. **Final Results**:
    - After all 100 rounds, the program outputs the number of wins for each player and the total number of draws.

6. **Reproducibility**:
    - A fixed random generator is used during tests to ensure consistent results across runs. This is important for testing scenarios like large rounds or edge cases.

## Code Overview

### Classes and Enums

1. **Move Enum**:
    - The `Move` enum defines the possible moves for the players: **ROCK**, **PAPER**, and **SCISSORS**.
    - The `getRandomMove()` method is used to randomly select a move for Player B.

2. **Result Enum**:
    - The `Result` enum represents the possible outcomes of a round: **WIN**, **LOSE**, and **DRAW**.

3. **Game Class**:
    - The `Game` class contains the main logic for evaluating the round results.
    - The `play()` method compares the moves of Player A and Player B to determine the result of the round.

4. **Main Class**:
    - The `Main` class runs the game for 100 rounds and tracks the number of wins and draws for both players.
    - After all rounds are played, the final results are printed.

### Randomness Control for Testing

In the `Move` enum, the randomness can be controlled by setting a fixed `Random` object using the `setRandom()` method. This allows for reproducible tests, which is useful when testing edge cases or large numbers of rounds.

```java
public static void setRandom(Random newRandom) {
    random = newRandom;
}
```
Test Cases
Standard Game Tests:

testDraws(): Ensures that the game correctly handles draws when both players choose the same move.
```java


assertEquals(Result.DRAW, game.play(Move.ROCK, Move.ROCK));
assertEquals(Result.DRAW, game.play(Move.PAPER, Move.PAPER));
assertEquals(Result.DRAW, game.play(Move.SCISSORS, Move.SCISSORS));

```
testPlayerAWins(): Ensures that Player A wins when their move beats Player B’s move.

```java
assertEquals(Result.WIN, game.play(Move.ROCK, Move.SCISSORS));
assertEquals(Result.WIN, game.play(Move.PAPER, Move.ROCK));
assertEquals(Result.WIN, game.play(Move.SCISSORS, Move.PAPER));
```
testPlayerBWins(): Ensures that Player B wins when their move beats Player A’s move.
```java
assertEquals(Result.LOSE, game.play(Move.ROCK, Move.PAPER));
assertEquals(Result.LOSE, game.play(Move.PAPER, Move.SCISSORS));
assertEquals(Result.LOSE, game.play(Move.SCISSORS, Move.ROCK));
```
Edge Case Tests:

testZeroRounds(): Tests the behavior when there are 0 rounds to play. This checks if the program can handle edge cases where no rounds are played.
```java
Game game = new Game();
int totalRounds = 0;
assertEquals(0, game.play(0)); // You can implement a check for 0 rounds
```
testLargeNumberOfRounds(): Tests the game with a very large number of rounds (1 million rounds in this case) to ensure it handles large iterations without issues.
```java

int totalRounds = 1000000;
// Here, you would run the game for 1 million rounds and check if it completes successfully
assertTrue(game.play(totalRounds));
```
Game Flow Tests:

testResultsSumToTotalRounds(): Verifies that the number of wins, losses, and draws sum up to the total number of rounds played, ensuring the program's consistency.
```java
Game game = new Game();
int totalRounds = 100;
int playerAWins = 0;
int playerBWins = 0;
int draws = 0;

for (int i = 0; i < totalRounds; i++) {
    Result result = game.play(Move.ROCK, Move.getRandomMove());
    if (result == Result.WIN) {
        playerAWins++;
    } else if (result == Result.LOSE) {
        playerBWins++;
    } else {
        draws++;
    }
}

assertEquals(totalRounds, playerAWins + playerBWins + draws);
Controlled Randomness Test:
```
testControlledRandomness(): Ensures that the random moves generated for Player B are consistent across runs when using a fixed seed for the random number generator.
```java
Random fixedSeedRandom = new Random(0); // fixed seed for reproducibility
Move.setRandom(fixedSeedRandom);
Game game = new Game();
assertEquals(Move.ROCK, game.play(Move.ROCK, Move.getRandomMove())); // Example result of the controlled randomness
```
Project Structure
The project is structured as follows:

src/
├── main/
│   ├── java/
│   │   ├── org/
│   │   │   ├── example/
│   │   │   │   ├── enums/
│   │   │   │   │   ├── Move.java
│   │   │   │   │   └── Result.java
│   │   │   │   ├── Game.java
│   │   │   │   └── Main.java
├── test/
│   ├── java/
│   │   ├── org/
│   │   │   ├── example/
│   │   │   │   └── GameTest.java
└── pom.xml

Move.java: Defines the moves in the game.
Result.java: Defines the possible results of each round.
Game.java: Contains the logic for determining the result of each round.
Main.java: Runs the game and displays the final results.
GameTest.java: Contains unit tests for the Game class.
pom.xml: Maven build file.


How to Run

Clone the repository:
```java
git clone <https://github.com/omargamal768/java-kotlin-coding-interview.git>
```
Build the project:
```java
mvn clean install
```
Run the main class:
```java
mvn exec:java -Dexec.mainClass="org.example.Main"
```
Run tests:
```java
mvn test
```
Conclusion
This is a simple implementation of Rock, Paper, Scissors with a fixed player (Player A always plays Rock) and a random player (Player B chooses randomly). It includes basic game logic, test coverage, and handles edge cases like 0 rounds and large numbers of rounds. The code is designed to be simple, yet easily extendable and testable.
