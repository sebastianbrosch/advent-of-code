package AoC2015.Day01;

/**
 * A solution for Advent of Code.
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
    String input = getInputString("AoC2015/Day01/input.txt");
    int floor = 0;

    for (char value : input.toCharArray()) {
      floor += (value == '(') ? 1 : -1;
    }

    return Integer.toString(floor);
  }

  /**
   * This function executes the second part of the puzzle.
   *
   * @return The solution of the second part of the puzzle.
   */
  public static String solve2() {
    String input = getInputString("AoC2015/Day01/input.txt");
    int floor = 0;

    char[] chars = input.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      floor += (chars[i] == '(') ? 1 : -1;

      if (floor == -1) {
        return Integer.toString(i + 1);
      }
    }

    return "0";
  }
}
