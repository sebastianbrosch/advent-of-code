package AoC2015.Day01;

/**
 * A solution for Advent of Code.
 */
public class Solution extends AoC.BaseSolution {

  /**
   * The main method. This method runs the solution.
   *
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    System.out.println(Solution.class.getPackageName());
    System.out.printf(" - Part 1: %s\n", solve1()); // solution: 138
    System.out.printf(" - Part 2: %s\n", solve2()); // solution: 1771
  }

  /**
   * This function executes the first part of the puzzle.
   *
   * @return The solution of the first part of the puzzle.
   */
  public static String solve1() {
    String input = getInputString("AoC2015/Day01/input.txt");
    Integer cntUp = 0;
    Integer cntDown = 0;

    char[] inputChars = input.toCharArray();

    for (Integer i = 0; i < inputChars.length; i++) {
      if (inputChars[i] == '(') {
        cntUp++;
      } else {
        cntDown++;
      }
    }

    return Integer.toString(cntUp - cntDown);
  }

  /**
   * This function executes the second part of the puzzle.
   *
   * @return The solution of the second part of the puzzle.
   */
  public static String solve2() {
    String input = getInputString("AoC2015/Day01/input.txt");
    Integer cntUp = 0;
    Integer cntDown = 0;

    char[] inputChars = input.toCharArray();

    for (Integer i = 0; i < inputChars.length; i++) {
      if (inputChars[i] == '(') {
        cntUp++;
      } else {
        cntDown++;
      }

      if (cntUp - cntDown == -1) {
        return Integer.toString(i + 1);
      }
    }

    return "0";
  }
}
