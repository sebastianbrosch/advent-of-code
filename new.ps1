param($year, $day)

$firstYear = 2015
$lastYear = 2023

if ((-not $year) -or ($year -lt $firstYear) -or ($year -gt $lastYear)) {
  throw "No valid year was specified. Please specify a valid year ($firstYear to $lastYear)."
}

if ((-not $day) -or ($day -lt 1) -or ($day -gt 25)) {
  throw "No valid day was specified. Please specify a valid day (1 to 25)."
}

$formatDay = '{0:d2}' -f $day
$folderPathDay = "AoC$year/Day$formatDay";
$filePathSolution = "$folderPathDay/Solution.java"

if (!(Test-Path -PathType Container $folderPathDay)) {
  New-Item -ItemType Directory -Path $folderPathDay | Out-Null
}

if ((Test-Path -PathType Leaf "AoC/Solution.java") -and (Test-Path -PathType Container $folderPathDay)) {
  Copy-Item "AoC/Solution.java" -Destination $folderPathDay
}

(Get-Content $filePathSolution).Replace('package AoC;', "package AoC$year.Day$formatDay;") | Set-Content $filePathSolution