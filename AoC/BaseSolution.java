package AoC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * The base solution with some useful methods.
 * These additional methods are available to all solutions.
 */
public abstract class BaseSolution {

  /**
   * Method to get the content of a file as string.
   * @param inputPath The file path of the file.
   * @return The file content or an empty string if the file is not available.
   */
  protected static String getInputString(String inputPath) {
    try {
      return new String(Files.readAllBytes(Paths.get(inputPath)));
    } catch(IOException e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * Method to get the content of a file as list of strings.
   * @param inputPath The file path of the file.
   * @return The file content as list of strings or an empty list if the file is not available.
   */
  protected static List<String> getInputLines(String inputPath) {
    try {
      return Files.readAllLines(Paths.get(inputPath));
    } catch(IOException e) {
      e.printStackTrace();
      return List.of();
    }
  }
}