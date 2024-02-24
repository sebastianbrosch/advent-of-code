package AoC2015.Day03;

import java.util.ArrayList;
import java.util.List;

/**
 * A solution for Advent of Code.
 *
 * @see https://adventofcode.com/2015/day/3
 * @see https://adventofcode.com/2015/day/3/input
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
    String input = getInputString("AoC2015/Day03/input.txt");
    List<String> positions = new ArrayList<String>();

    Integer[] coords = {0, 0};
    positions.add("0:0");

    for (char direction : input.toCharArray()) {
      switch (direction) {
        case '^', 'v':
          coords[1] += (direction == '^') ? 1 : -1;
          break;
        case '<', '>':
          coords[0] += (direction == '>') ? 1 : -1;
          break;
      }

      String positionKey = coords[0] + ":" + coords[1];

      if (positions.contains(positionKey) == false) {
        positions.add(positionKey);
      }
    }

    return Integer.toString(positions.size());
  }

  /**
   * This function executes the second part of the puzzle.
   *
   * @return The solution of the second part of the puzzle.
   */
  public static String solve2() {
    String input = getInputString("AoC2015/Day03/input.txt");
    List<String> positions = new ArrayList<String>();

    Integer[] coordsSanta = {0, 0};
    Integer[] coordsRoboSanta = {0, 0};
    positions.add("0:0");

    char[] directions = input.toCharArray();

    for (int i = 0; i < directions.length; i++) {
      char direction = directions[i];

      Integer[] coords = (i % 2 == 1) ? coordsSanta : coordsRoboSanta;

      switch (direction) {
        case '^', 'v':
          coords[1] += (direction == '^') ? 1 : -1;
          break;
        case '<', '>':
          coords[0] += (direction == '>') ? 1 : -1;
          break;
      }

      String positionKey = coords[0] + ":" + coords[1];

      if (positions.contains(positionKey) == false) {
        positions.add(positionKey);
      }
    }

    return Integer.toString(positions.size());
  }
}
