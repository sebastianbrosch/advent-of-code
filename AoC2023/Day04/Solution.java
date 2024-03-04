package AoC2023.Day04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A solution for Advent of Code.
 *
 * @see https://adventofcode.com/2023/day/4
 * @see https://adventofcode.com/2023/day/4/input
 */
public class Solution extends AoC.BaseSolution {

  /**
   * The main method. This method runs the solutions.
   *
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    System.out.println(Solution.class.getPackageName());
    System.out.printf(" - Part 1: %s\n", Solution.part1());
    System.out.printf(" - Part 2: %s\n", Solution.part2());
  }

  /**
   * This function executes the first part of the puzzle.
   *
   * @return The solution of the first part of the puzzle.
   */
  private static String part1() {
    List<String> cards = getInputLines("AoC2023/Day04/input.txt");
    int sum = 0;

    for (String card : cards) {
      List<String> winningNumbers = Arrays.asList(card.substring(card.indexOf(":"), card.indexOf("|")).trim().split(" "));
      List<String> havingNumbers = Arrays.asList(card.substring(card.indexOf("|")).trim().split(" "));
      int cntWinningNumbers = 0;

      for (String havingNumber : havingNumbers) {
        if (havingNumber != "" && winningNumbers.contains(havingNumber)) {
          cntWinningNumbers++;
        }
      }

      sum += Math.pow(2, cntWinningNumbers - 1);
    }

    return Integer.toString(sum);
  }

  /**
   * This function executes the second part of the puzzle.
   *
   * @return The solution of the second part of the puzzle.
   */
  private static String part2() {
    List<String> lines = getInputLines("AoC2023/Day04/input.txt");
    Map<Integer, int[]> cards = new HashMap<Integer, int[]>();
    int sum = 0;

    for (String line : lines) {
      String number = line.substring(line.indexOf(" "), line.indexOf(":")).trim();
      List<String> winningNumbers = Arrays.asList(line.substring(line.indexOf(":"), line.indexOf("|")).trim().split(" "));
      List<String> havingNumbers = Arrays.asList(line.substring(line.indexOf("|")).trim().split(" "));
      int cntWinningNumbers = 0;

      for (String havingNumber : havingNumbers) {
        if (havingNumber != "" && winningNumbers.contains(havingNumber)) {
          cntWinningNumbers++;
        }
      }

      cards.put(Integer.parseInt(number), new int[] {cntWinningNumbers, 1});
    }

    for (int number : cards.keySet()) {
      int[] info = cards.get(number);

      for (int i = number + 1; i < (number + 1 + info[0]); i++) {
        cards.get(i)[1] += info[1];
      }
    }

    for (int number : cards.keySet()) {
      sum += cards.get(number)[1];
    }

    return Integer.toString(sum);
  }
}
