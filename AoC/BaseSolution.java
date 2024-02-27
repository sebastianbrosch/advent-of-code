package AoC;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * The base solution with some useful methods.
 */
public abstract class BaseSolution {
  protected final static String HASH_MD5 = "MD5";
  protected final static String HASH_SHA1 = "SHA-1";
  protected final static String HASH_SHA256 = "SHA-256";

  /**
   * Method to get the content of a file as list of strings.
   *
   * @param inputPath The file path of the file.
   * @return The file content as list of strings or an empty list if the file is not available.
   */
  protected static List<String> getInputLines(String inputPath) {
    try {
      return Files.readAllLines(Paths.get(inputPath));
    } catch (IOException e) {
      e.printStackTrace();
      return List.of();
    }
  }

  /**
   * Method to get the content of a file as a string.
   * @param inputPath The path to the file.
   * @return The content of the file or an empty string if the file is not available.
   */
  protected static String getInputString(String inputPath) {
    try {
      return new String(Files.readString(Paths.get(inputPath)));
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * Method to determine a hash from a string.
   * @param value The string value.
   * @param hash The hash type to be used.
   * @return The hash of the given string or a empty string if the hash type is not known.
   */
  protected static String getHashOfString(String value, String hash) {
    try {
      MessageDigest msgDigest = MessageDigest.getInstance(hash);
      BigInteger bigint = new BigInteger(1, msgDigest.digest(value.getBytes()));
      String hashtext = bigint.toString(16);
      return "0".repeat(32 - hashtext.length()) + hashtext;
    } catch (NoSuchAlgorithmException e) {
      return "";
    }
  }
}
