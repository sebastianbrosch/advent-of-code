package AoC2015.Day05;

import java.util.List;

/**
 * A solution for Advent of Code.
 *
 * @see https://adventofcode.com/2015/day/5
 * @see https://adventofcode.com/2015/day/5/input
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
    List<String> lines = getInputLines("AoC2015/Day05/input.txt");
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    String[] blacklist = {"ab", "cd", "pq", "xy"};
    int sum = 0;

    for (String line : lines) {
      char[] lineChars = line.toCharArray();
      int cntVowels = 0;
      boolean hasDoubleLetter = false;
      boolean hasBadWord = false;

      for (char lineChar : lineChars) {
        for (char vowel : vowels) {
          if (vowel == lineChar) {
            cntVowels++;
            break;
          }
        }
      }

      for (int i = 0; i < line.length() - 1; i++) {
        String check = line.substring(i, i + 2);

        if (check.charAt(0) == check.charAt(1)) {
          hasDoubleLetter = true;
          break;
        }
      }

      for (String word : blacklist) {
        if (line.contains(word)) {
          hasBadWord = true;
          break;
        }
      }

      if (!hasBadWord && hasDoubleLetter && cntVowels >= 3) {
        sum++;
      }
    }

    return Integer.toString(sum);
  }

  /**
   * This function executes the second part of the puzzle.
   *
   * @return The solution of the second part of the puzzle.
   */
  private static String part2() {
    List<String> lines = getInputLines("AoC2015/Day05/input.txt");
    int sum = 0;

    for (String line : lines) {
      boolean hasPairOfLetters = false;
      boolean hasRepeatingLetterWithSpace = false;

      for (int i = 0; i < line.length() - 1; i++) {
        String check = line.substring(i, i + 2);

        if (line.indexOf(check, i + 2) >= 0) {
          hasPairOfLetters = true;
          break;
        }
      }

      for (int i = 0; i < line.length() - 2; i++) {
        String check = line.substring(i, i + 3);

        if (check.charAt(0) == check.charAt(2)) {
          hasRepeatingLetterWithSpace = true;
          break;
        }
      }

      if (hasPairOfLetters && hasRepeatingLetterWithSpace) {
        sum++;
      }
    }

    return Integer.toString(sum);
  }
}
