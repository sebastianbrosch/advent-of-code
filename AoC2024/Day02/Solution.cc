#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <sstream>

/**
 * This function gets a vector with all integer values of a string.
 *
 * @param string The string to get the integer values from.
 * @param char The delimiter to split the integer values of the string.
 * @return A vector with all integer values of the string.
 */
std::vector<int> split(const std::string input, char delimiter = ',') {
  std::stringstream ss(input);
  std::vector<int> values;
  std::string token;

  while (std::getline(ss, token, delimiter)) {
    values.push_back(std::stoi(token));
  }

  return values;
}

/**
 * This function executes the first part of the puzzle.
 *
 * @return The solution of the first part of the puzzle.
 */
std::string part1() {
  std::ifstream input("input.txt");

  if (input.is_open()) {
    std::string line;
    int sum = 0;

    while (std::getline(input, line)) {
      std::vector<int> levels = split(line, ' ');

      for (int i = 0; i < levels.size() - 1; ++i) {
        int direction = levels[0] - levels[1];
        int difference = levels[i] - levels[i + 1];

        if (std::abs(difference) > 3 || std::abs(difference) < 1) {
          break;
        }

        if ((direction < 0 && difference > 0)  || (direction > 0 && difference < 0)) {
          break;
        }

        sum += (i + 2 == levels.size()) ? 1 : 0;
      }
    }

    return std::to_string(sum);
  } else {
    return "";
  }
}

/**
 * This function executes the second part of the puzzle.
 *
 * @return The solution of the second part of the puzzle.
 */
std::string part2() {
  std::ifstream input("input.txt");

  if (input.is_open()) {
    std::string line;
    int sum = 0;

    while (std::getline(input, line)) {
      std::vector<int> flevels = split(line, ' ');

      for (int j = flevels.size(); j >= 0; --j) {
        std::vector<int> levels = flevels;
        bool valid = true;

        if (j != flevels.size()) {
          levels.erase(levels.begin() + j);
        }

        for (int i = 0; i < levels.size() - 1; ++i) {
          int direction = levels[0] - levels[1];
          int difference = levels[i] - levels[i + 1];

          if (std::abs(difference) > 3 || std::abs(difference) < 1) {
            valid = false;
            break;
          }

          if ((direction < 0 && difference > 0)  || (direction > 0 && difference < 0)) {
            valid = false;
            break;
          }
        }

        if (valid) {
          sum++;
          break;
        }
      }
    }

    return std::to_string(sum);
  } else {
    return "";
  }
}

/**
 * A solution for Advent of Code.
 *
 * @see https://adventofcode.com/2024/day/2
 * @see https://adventofcode.com/2024/day/2/input
 */
int main() {
  std::cout << "AoC2024.Day2" << std::endl;
  std::cout << " - Part 1: " << part1() << std::endl;
  std::cout << " - Part 2: " << part2() << std::endl;
  return 0;
}
