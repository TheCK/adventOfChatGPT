package org.ck.adventofchatgpt.year2022.day02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part2 {
  public static void main(String[] args) {
    // Read the strategy guide from standard input.
    Scanner scanner = new Scanner(System.in);
    StringBuilder strategyGuide = new StringBuilder();
    while (scanner.hasNextLine()) {
      // Parse each round and add it to the strategy guide string.
      String line = scanner.nextLine();
      strategyGuide.append(line.charAt(0));
      strategyGuide.append(line.charAt(2));
    }

    // Initialize a map that maps each shape to its corresponding score.
    Map<String, Integer> scores = new HashMap<>();
    scores.put("R", 1);
    scores.put("P", 2);
    scores.put("S", 3);
    // Initialize a map that maps each shape to the shape it defeats.
    Map<String, String> defeats = new HashMap<>();
    defeats.put("R", "S");
    defeats.put("P", "R");
    defeats.put("S", "P");

    // Initialize the total score to 0.
    int totalScore = 0;

    // Parse the strategy guide and simulate the tournament.
    for (int i = 0; i < strategyGuide.length(); i += 2) {
      // Determine the shape chosen by the opponent in this round.
      String opponentShape = strategyGuide.substring(i, i + 1);

      // Determine the outcome you need for the round.
      String outcomeNeeded = strategyGuide.substring(i + 1, i + 2);

      // Choose the shape that will give you the desired outcome for the round.
      String yourShape;
      if (outcomeNeeded.equals("X")) {
        yourShape =
            defeats.get(opponentShape); // Choose the shape that defeats the opponent's shape.
      } else if (outcomeNeeded.equals("Y")) {
        yourShape = opponentShape; // Choose the same shape as the opponent.
      } else {
        yourShape =
            defeats.get(
                defeats.get(
                    opponentShape)); // Choose the shape that is defeated by the opponent's shape.
      }

      // Determine the actual outcome of the round.
      String outcome;
      if (yourShape.equals(opponentShape)) {
        outcome = "D"; // Draw
      } else if (defeats.get(yourShape).equals(opponentShape)) {
        outcome = "W"; // Win
      } else {
        outcome = "L"; // Lose
      }

      // Calculate the score for the round.
      int score = scores.get(yourShape) + (outcome.equals("D") ? 3 : (outcome.equals("W") ? 6 : 0));

      // Add the round score to the total score.
      totalScore += score;
    }

    // Print the total score.
    System.out.println(totalScore);
  }
}
