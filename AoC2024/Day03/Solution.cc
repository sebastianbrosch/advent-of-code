#include <iostream>
#include <string>
#include <fstream>
#include <regex>

/**
 * This function executes the first part of the puzzle.
 *
 * @return The solution of the first part of the puzzle.
 */
std::string part1() {
  std::ifstream input("input.txt");

  if (input.is_open()) {
    std::string line;
    std::regex regex_words("mul\\(([0-9]{1,3}),([0-9]{1,3})\\)");
    int sum = 0;

    while (std::getline(input, line)) {
      auto words_begin = std::sregex_iterator(line.begin(), line.end(), regex_words);
      auto words_end = std::sregex_iterator();

      for (std::sregex_iterator i = words_begin; i != words_end; ++i) {
        std::smatch match = *i;
        sum += (std::stoi(match[1].str()) * std::stoi(match[2].str()));
      }
    }

    return std::to_string(sum);
  }

  return "";
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

    std::regex rmul("mul\\(([0-9]{1,3}),([0-9]{1,3})\\)");
    std::regex rdo("do(n't)?\\(\\)");

    bool isactive = true;

    while (std::getline(input, line)) {
      int last = (isactive) ? 0 : INT_MAX;
      std::vector<std::pair<int, int>> active_ranges;

      auto do_begin = std::sregex_iterator(line.begin(), line.end(), rdo);
      auto do_end = std::sregex_iterator();

      for (std::sregex_iterator i = do_begin; i != do_end; ++i) {
        std::smatch match = *i;

        if (match.str() == "don't()") {
          if (isactive) {
            std::pair<int, int> range(last, match.position());
            active_ranges.push_back(range);
          }

          isactive = false;
        } else if (match.str() == "do()") {
          if (isactive) continue;
          isactive = true;
          last = match.position();
        }
      }

      if (isactive) {
        std::pair<int, int> range(last, INT_MAX);
        active_ranges.push_back(range);
      }

      auto mul_begin = std::sregex_iterator(line.begin(), line.end(), rmul);
      auto mul_end = std::sregex_iterator();

      for (std::sregex_iterator i = mul_begin; i != mul_end; ++i) {
        std::smatch match = *i;

        for (int j = 0; j < active_ranges.size(); ++j) {
          if (std::get<0>(active_ranges[j]) <= match.position() && match.position() <= std::get<1>(active_ranges[j])) {
            sum += (std::stoi(match[1].str()) * std::stoi(match[2].str()));
            break;
          }
        }
      }
    }

    return std::to_string(sum);
  }

  return "";
}

/**
 * A solution for Advent of Code.
 *
 * @see https://adventofcode.com/2024/day/3
 * @see https://adventofcode.com/2024/day/3/input
 */
int main() {
  std::cout << "AoC2024.Day3" << std::endl;
  std::cout << " - Part 1: " << part1() << std::endl;
  std::cout << " - Part 2: " << part2() << std::endl;
  return 0;
}
