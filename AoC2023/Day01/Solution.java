package AoC2023.Day01;

import java.util.List;

/**
 * A solution for Advent of Code.
 *
 * @see https://adventofcode.com/2023/day/1
 * @see https://adventofcode.com/2023/day/1/input
 */
public class Solution extends AoC.BaseSolution {

  /**
   * The main method. This method runs the solutions.
   *
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    System.out.println(Solution.class.getPackageName());
    System.out.printf(" - Part 1: %s\n", solve1());
    System.out.printf(" - Part 2: %s\n", solve2());
  }

  /**
   * This function executes the first part of the puzzle.
   *
   * @return The solution of the first part of the puzzle.
   */
  public static String solve1() {
    List<String> lines = getInputLines("AoC2023/Day01/input.txt");
    Integer sum = 0;

    for (String line : lines) {
      char firstNumeric = ' ';
      char lastNumeric = ' ';

      for (char character : line.toCharArray()) {
        if (Character.isDigit(character)) {
          lastNumeric = character;

          if (firstNumeric == ' ') {
            firstNumeric = lastNumeric;
          }
        }
      }

      sum += Integer.valueOf("" + firstNumeric + lastNumeric);
    }

    return sum.toString();
  }

  /**
   * This function executes the second part of the puzzle.
   *
   * @return The solution of the second part of the puzzle.
   */
  public static String solve2() {
    List<String> lines = getInputLines("AoC2023/Day01/input.txt");
    String[] digits =
        {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    Integer sum = 0;

    for (String line : lines) {
      char firstNumeric = ' ';
      char lastNumeric = ' ';

      for (char character : line.toCharArray()) {
        if (Character.isDigit(character)) {
          lastNumeric = character;

          if (firstNumeric == ' ') {
            firstNumeric = lastNumeric;
          }
        }
      }

      int firstIndex = line.indexOf(firstNumeric);
      int lastIndex = line.lastIndexOf(lastNumeric);

      for (int k = 0; k < digits.length; k++) {
        if (line.lastIndexOf(digits[k]) < 0) {
          continue;
        }

        if (line.indexOf(digits[k]) < firstIndex) {
          firstIndex = line.indexOf(digits[k]);
          firstNumeric = Character.forDigit(k, 10);
        }

        if (line.lastIndexOf(digits[k]) > lastIndex) {
          lastIndex = line.lastIndexOf(digits[k]);
          lastNumeric = Character.forDigit(k, 10);
        }
      }

      sum += Integer.valueOf("" + firstNumeric + lastNumeric);
    }

    return sum.toString();
  }
}
