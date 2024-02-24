package AoC2015.Day02;

import java.util.List;

/**
 * A solution for Advent of Code.
 *
 * @see https://adventofcode.com/2015/day/2
 * @see https://adventofcode.com/2015/day/2/input
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
    List<String> presents = getInputLines("AoC2015/Day02/input.txt");
    Integer paper = 0;

    for(String present : presents) {
      String[] dimensions = present.split("x");

      int length = Integer.parseInt(dimensions[0]);
      int width = Integer.parseInt(dimensions[1]);
      int height = Integer.parseInt(dimensions[2]);

      int surface1 = length * width;
      int surface2 = width * height;
      int surface3 = height * length;

      paper += (2 * surface1) + (2 * surface2) + (2 * surface3) + Math.min(Math.min(surface1, surface2), surface3);
    }

    return paper.toString();
  }

  /**
   * This function executes the second part of the puzzle.
   *
   * @return The solution of the second part of the puzzle.
   */
  public static String solve2() {
    List<String> presents = getInputLines("AoC2015/Day02/input.txt");
    Integer ribbon = 0;

    for(String present : presents) {
      String[] dimensions = present.split("x");

      int length = Integer.parseInt(dimensions[0]);
      int width = Integer.parseInt(dimensions[1]);
      int height = Integer.parseInt(dimensions[2]);

      ribbon += 2* (length + width + height) - 2 * Math.max(Math.max(length, width), height);
      ribbon += length * width * height;
    }

    return ribbon.toString();
  }
}
