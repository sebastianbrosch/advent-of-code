package AoC2015.Day04;

import AoC.BaseSolution;

/**
 * A solution for Advent of Code.
 *
 * @see https://adventofcode.com/2015/day/4
 * @see https://adventofcode.com/2015/day/4/input
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
    String input = getInputString("AoC2015/Day04/input.txt").trim();

    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      if (getHashOfString(input + i, BaseSolution.HASH_MD5).startsWith("00000")) {
        return Integer.toString(i);
      }
    }

    return "0";
  }

  /**
   * This function executes the second part of the puzzle.
   *
   * @return The solution of the second part of the puzzle.
   */
  public static String solve2() {
    String input = getInputString("AoC2015/Day04/input.txt").trim();

    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      if (getHashOfString(input + i, BaseSolution.HASH_MD5).startsWith("000000")) {
        return Integer.toString(i);
      }
    }

    return "0";
  }
}
