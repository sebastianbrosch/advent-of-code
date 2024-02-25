package AoC2023.Day02;

import java.util.List;

/**
 * A solution for Advent of Code.
 *
 * @see https://adventofcode.com/2023/day/2
 * @see https://adventofcode.com/2023/day/2/input
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
    List<String> games = getInputLines("AoC2023/Day02/input.txt");
    Integer sum = 0;

    // red, blue, green
    int[] bag = {12, 14, 13};

    for (String game : games) {
      String gameTitle = game.split(":")[0];
      String[] gameSet = game.split(":")[1].split(";");
      boolean isGameOK = true;

      for (String setInfo : gameSet) {
        String[] cubes = setInfo.split(",");

        for (String cube : cubes) {
          String[] cubeInfo = cube.trim().split(" ");
          String color = cubeInfo[1];
          int cnt = Integer.parseInt(cubeInfo[0]);

          if (color.equals("red") && cnt > bag[0]) {
            isGameOK = false;
          } else if (color.equals("blue") && cnt > bag[1]) {
            isGameOK = false;
          } else if (color.equals("green") && cnt > bag[2]) {
            isGameOK = false;
          }
        }
      }

      if (isGameOK) {
        sum += Integer.parseInt(gameTitle.split(" ")[1]);
      }
    }

    return Integer.toString(sum);
  }

  /**
   * This function executes the second part of the puzzle.
   *
   * @return The solution of the second part of the puzzle.
   */
  public static String solve2() {
    List<String> games = getInputLines("AoC2023/Day02/input.txt");
    Integer sum = 0;

    for (String game : games) {
      String[] gameSet = game.split(":")[1].split(";");

      // red, blue, green
      int[] bag = {0, 0, 0};

      for (String setInfo : gameSet) {
        String[] cubes = setInfo.split(",");

        for (String cube : cubes) {
          String[] cubeInfo = cube.trim().split(" ");
          String color = cubeInfo[1];

          if (color.equals("red")) {
            bag[0] = Math.max(bag[0], Integer.parseInt(cubeInfo[0]));
          }

          if (color.equals("blue")) {
            bag[1] = Math.max(bag[1], Integer.parseInt(cubeInfo[0]));
          }

          if (color.equals("green")) {
            bag[2] = Math.max(bag[2], Integer.parseInt(cubeInfo[0]));
          }
        }
      }

      sum += bag[0] * bag[1] * bag[2];
    }

    return Integer.toString(sum);
  }
}
