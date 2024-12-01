<#
.SYNOPSIS
  Creates a new solution for Advent of Code.
.DESCRIPTION
  This script creates a new solution for Advent of Code.
.PARAMETER Year
  The year of the solution to create.
.PARAMETER Day
  The day of the solution to create.
.PARAMETER Language
  The language of the solution to create.
.NOTES
  Author: Sebastian Brosch
.EXAMPLE
  Create the solution of Advent of Code 2024 - Day 1 using C++.
  .\New-Solution -Year 2024 -Day 1 -Language C++
  .\New-Solution 2024 1 C++
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

$formatDay = '{0:d2}' -f $Day
$folderPathDay = "AoC$Year/Day$formatDay";
$urlPuzzle = "https://adventofcode.com/$Year/day/$Day"

if (-not (Test-Path -PathType Container $folderPathDay)) {
  New-Item -ItemType Directory -Path $folderPathDay | Out-Null
}

switch ($Language.ToUpper()) {
  'C++' {
    if ((Test-Path -PathType Leaf "AoC/Solution.cc") -and (Test-Path -PathType Container $folderPathDay)) {
      if (-not (Test-Path -PathType Leaf "$folderPathDay/Solution.cc")) {
        Copy-Item "AoC/Solution.cc" -Destination $folderPathDay
      }
    }

    $filePathSolution = "$folderPathDay/Solution.cc"
    (Get-Content $filePathSolution).Replace('$Year', "$Year") | Set-Content $filePathSolution
    (Get-Content $filePathSolution).Replace('$Day', "$Day") | Set-Content $filePathSolution
  }
  'JAVA' {
    if ((Test-Path -PathType Leaf "AoC/Solution.java") -and (Test-Path -PathType Container $folderPathDay)) {
      if (-not (Test-Path -PathType Leaf "$folderPathDay/Solution.java")) {
        Copy-Item "AoC/Solution.java" -Destination $folderPathDay
      }
    }

    $filePathSolution = "$folderPathDay/Solution.java"
    (Get-Content $filePathSolution).Replace('package AoC;', "package AoC$year.Day$formatDay;") | Set-Content $filePathSolution
    (Get-Content $filePathSolution).Replace('$Year', "$Year") | Set-Content $filePathSolution
    (Get-Content $filePathSolution).Replace('$Day', "$Day") | Set-Content $filePathSolution
  }
}

Write-Host "Advent of Code $Year - Day ${formatDay}: $urlPuzzle"
Write-Host "Advent of Code $Year - Day ${formatDay} - Input: $urlPuzzle/input"

Start-Process $urlPuzzle
Start-Process "$urlPuzzle/input"