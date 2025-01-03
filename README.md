# Advent of Code
This repository is used to store my solutions for Advent of Code. I'm using the puzzles to learn or practice some programming languages or technologies.

- [Advent of Code 2015](https://adventofcode.com/2015) - [Solutions](AoC2015) (Java)
- [Advent of Code 2016](https://adventofcode.com/2016)
- [Advent of Code 2017](https://adventofcode.com/2017)
- [Advent of Code 2018](https://adventofcode.com/2018)
- [Advent of Code 2019](https://adventofcode.com/2019)
- [Advent of Code 2020](https://adventofcode.com/2020)
- [Advent of Code 2021](https://adventofcode.com/2021)
- [Advent of Code 2022](https://adventofcode.com/2022)
- [Advent of Code 2023](https://adventofcode.com/2023) - [Solutions](AoC2023) (Java)
- [Advent of Code 2024](https://adventofcode.com/2024) - [Solutions](AoC2024) (C++)

## Powershell Scripts
You can create a new solution using the script `New-Solution`. An existing solution can be executed with the script `Run-Solution`. To create and run the solution for Advent of Code 2024 - Day 1 using C++ you can use the scripts like this:

```
.\New-Solution 2024 1 C++
.\Run-Solution 2024 1 C++
```

You can also use the named parameters to run the scripts:

```
.\New-Solution -Year 2024 -Day 1 -Language C++
.\Run-Solution -Year 2024 -Day 1 -Language C++
```

It is also possible to remove all compiled files (`.class`, `.exe`) using the script `Cleanup`:

```
.\Cleanup
```