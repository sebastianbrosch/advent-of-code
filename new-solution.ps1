<#
.SYNOPSIS
  Creates a new solution for Advent of Code.
.DESCRIPTION
  This script creates a new solution for Advent of Code.
.PARAMETER Year
  The year of the solution to create.
.PARAMETER Day
  The day of the solution to create.
.NOTES
  Author: Sebastian Brosch
.EXAMPLE
  Create the solution of Advent of Code 2023 - Day 1.
  .\New-Solution -Year 2023 -Day 1
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

$formatDay = '{0:d2}' -f $Day
$folderPathDay = "AoC$Year/Day$formatDay";
$filePathSolution = "$folderPathDay/Solution.java"
$urlPuzzle = "https://adventofcode.com/$Year/day/$Day"

if (-not (Test-Path -PathType Container $folderPathDay)) {
  New-Item -ItemType Directory -Path $folderPathDay | Out-Null
}

if ((Test-Path -PathType Leaf "AoC/Solution.java") -and (Test-Path -PathType Container $folderPathDay)) {
  Copy-Item "AoC/Solution.java" -Destination $folderPathDay
}

(Get-Content $filePathSolution).Replace('package AoC;', "package AoC$year.Day$formatDay;") | Set-Content $filePathSolution

Write-Host "Advent of Code $Year - Day ${formatDay}: $urlPuzzle"
Write-Host "Advent of Code $Year - Day ${formatDay} - Input: $urlPuzzle/input"

Start-Process $urlPuzzle
Start-Process "$urlPuzzle/input"