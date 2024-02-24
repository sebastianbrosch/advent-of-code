<#
.SYNOPSIS
  Runs a specific solution for Advent of Code.
.DESCRIPTION
  This script compiles and runs a specific solution for Advent of Code.
.PARAMETER Year
  The year of the solution to compile and run.
.PARAMETER Day
  The day of the solution to compile and run.
.NOTES
  Author: Sebastian Brosch
.EXAMPLE
  Run the solution of Advent of Code 2023 - Day 1.
  .\Run-Solution -Year 2023 -Day 1
#>
param(
  [UInt16]$Year,
  [UInt16]$Day
)

$firstYear = 2015
$lastYear = 2023

if ((-not $Year) -or ($Year -lt $firstYear) -or ($Year -gt $lastYear)) {
  throw "No valid year was specified. Please specify a valid year ($firstYear to $lastYear)."
}

if ((-not $Day) -or ($Day -lt 1) -or ($Day -gt 25)) {
  throw "No valid day was specified. Please specify a valid day (1 to 25)."
}

if ((-not (Get-Command java -ErrorAction SilentlyContinue)) -or (-not (Get-Command javac -ErrorAction SilentlyContinue))) {
  throw "Java is not installed. Please install Java."
}

$formatDay = '{0:d2}' -f $Day
$folderPathDay = "AoC$Year/Day$formatDay"
$filePathSolution = "$folderPathDay/Solution.java"
$urlPuzzle = "https://adventofcode.com/$Year/day/$Day"

if (Test-Path $filePathSolution -PathType Leaf) {
  javac $filePathSolution
  java $filePathSolution.Replace('/', '.').Replace('.java', '')
}

Write-Host "Advent of Code $Year - Day ${formatDay}: $urlPuzzle"