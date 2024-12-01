#include <iostream>
#include <string>
#include <fstream>
#include <set>

/**
 * This function executes the first part of the puzzle.
 *
 * @return The solution of the first part of the puzzle.
 */
std::string part1() {
  std::ifstream input("input.txt");

  if (input.is_open()) {
    int ln, rn;
    std::multiset<int> ll, rl;

    while (input >> ln >> rn) {
      ll.insert(ln);
      rl.insert(rn);
    }

    int sum = 0;

    for (int i = 0; i < ll.size(); ++i) {
      std::set<int>::iterator lit = ll.begin();
      std::set<int>::iterator rit = rl.begin();
      std::advance(lit, i);
      std::advance(rit, i);
      sum += std::abs(*lit - *rit);
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
    int ln, rn;
    std::multiset<int> ll, rl;

    while (input >> ln >> rn) {
      ll.insert(ln);
      rl.insert(rn);
    }

    int sum = 0;

    for (std::multiset<int>::iterator it = ll.begin(); it != ll.end(); ++it) {
      int number = *it;
      sum += *it * rl.count(number);
    }

    return std::to_string(sum);
  } else {
    return "";
  }
}

/**
 * A solution for Advent of Code.
 *
 * @see https://adventofcode.com/2024/day/1
 * @see https://adventofcode.com/2024/day/1/input
 */
int main() {
  std::cout << "AoC2024.Day1" << std::endl;
  std::cout << " - Part 1: " << part1() << std::endl;
  std::cout << " - Part 2: " << part2() << std::endl;
  return 0;
}
