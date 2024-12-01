<#
.SYNOPSIS
  Runs a specific solution for Advent of Code.
.DESCRIPTION
  This script compiles and runs a specific solution for Advent of Code.
.PARAMETER Year
  The year of the solution to compile and run.
.PARAMETER Day
  The day of the solution to compile and run.
.PARAMETER Language
  The language of the solution to compile and run.
.NOTES
  Author: Sebastian Brosch
.EXAMPLE
  Run the solution of Advent of Code 2024 - Day 1 using C++.
  .\Run-Solution -Year 2024 -Day 1 -Language C++
  .\Run-Solution 2024 1 C++
#>
param(
  [UInt16]$Year,
  [UInt16]$Day,
  [String]$Language
)

$firstYear = 2015
$lastYear = 2024

if ((-not $Year) -or ($Year -lt $firstYear) -or ($Year -gt $lastYear)) {
  throw "No valid year was specified. Please specify a valid year ($firstYear to $lastYear)."
}

if ((-not $Day) -or ($Day -lt 1) -or ($Day -gt 25)) {
  throw "No valid day was specified. Please specify a valid day (1 to 25)."
}

if (@('C++', 'JAVA') -notcontains $Language.ToUpper()) {
  throw "No valid language was specified. Please specify a valid language (C++, Java)."
}

switch ($Language.ToUpper()) {
  'C++' {
    if ((-not (Get-Command g++ -ErrorAction SilentlyContinue))) {
      throw "C++ Compiler is not installed. Please install G++."
    }
  }
  'JAVA' {
    if ((-not (Get-Command java -ErrorAction SilentlyContinue)) -or (-not (Get-Command javac -ErrorAction SilentlyContinue))) {
      throw "Java is not installed. Please install Java."
    }
  }
}

$formatDay = '{0:d2}' -f $Day
$folderPathDay = "AoC$Year/Day$formatDay"
$urlPuzzle = "https://adventofcode.com/$Year/day/$Day"

switch ($Language.ToUpper()) {
  'C++' {
    Push-Location -Path $folderPathDay
    g++ -o Solution.exe Solution.cc
    & ".\Solution.exe"
    Pop-Location
  }
  'JAVA' {
    $filePathSolution = "$folderPathDay/Solution.java"
    javac $filePathSolution
    java $filePathSolution.Replace('/', '.').Replace('.java', '')
  }
}

Write-Host "Advent of Code $Year - Day ${formatDay}: $urlPuzzle"