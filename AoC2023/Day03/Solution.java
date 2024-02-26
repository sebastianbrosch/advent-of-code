package AoC2023.Day03;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A solution for Advent of Code.
 *
 * @see https://adventofcode.com/2023/day/3
 * @see https://adventofcode.com/2023/day/3/input
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
    List<String> lines = getInputLines("AoC2023/Day03/input.txt");
    Pattern number = Pattern.compile("(\\d+)");
    Pattern part = Pattern.compile("([^\\d\\.])");
    Integer sum = 0;

    for (int i = 0; i < lines.size(); i++) {
      String line = lines.get(i);
      Matcher numberMatcher = number.matcher(line);

      while (numberMatcher.find()) {
        boolean isPartNumber = false;
        int indexPrevious = Math.max(i - 1, 0);
        int indexNext = Math.min(i + 1, lines.size() - 1);

        for (int j = indexPrevious; j <= indexNext; j++) {
          String partLine = lines.get(j);

          int lineStart = Math.max(numberMatcher.start() - 1, 0);
          int lineEnd = Math.min(numberMatcher.end() + 1, line.length());

          Matcher partMatcher = part.matcher(partLine.substring(lineStart, lineEnd));

          if (partMatcher.find()) {
            isPartNumber = true;
            break;
          }
        }

        if (isPartNumber) {
          sum += Integer.parseInt(numberMatcher.group());
        }
      }
    }

    return sum.toString();
  }

  /**
   * This function executes the second part of the puzzle.
   *
   * @return The solution of the second part of the puzzle.
   */
  public static String solve2() {
    List<String> lines = getInputLines("AoC2023/Day03/input.txt");
    Pattern gear = Pattern.compile("([\\*])");
    Pattern number = Pattern.compile("(\\d+)");
    int sum = 0;

    for (int i = 0; i < lines.size(); i++) {
      String line = lines.get(i);
      Matcher gearMatcher = gear.matcher(line);

      while (gearMatcher.find()) {
        int indexPreviousLine = Math.max(i - 1, 0);
        int indexNextLine = Math.min(i + 1, lines.size() - 1);
        int partStart = Math.max(gearMatcher.start() - 1, 0);
        int partEnd = Math.min(gearMatcher.end(), line.length() - 1);
        int[] numbers = {0, 0};

        for (int j = indexPreviousLine; j <= indexNextLine; j++) {
          Matcher numberMatcher = number.matcher(lines.get(j));

          while (numberMatcher.find()) {
            int numberStart = numberMatcher.start();
            int numberEnd = numberMatcher.end() - 1;

            if ((partStart <= numberStart && numberStart <= partEnd)
                || (partStart <= numberEnd && numberEnd <= partEnd)) {
              if (numbers[0] == 0) {
                numbers[0] = Integer.parseInt(numberMatcher.group());
              } else if (numbers[1] == 0) {
                numbers[1] = Integer.parseInt(numberMatcher.group());
              }

              if (numbers[0] > 0 && numbers[1] > 0) {
                sum += numbers[0] * numbers[1];
              }
            }
          }
        }
      }
    }

    return Integer.toString(sum);
  }
}
