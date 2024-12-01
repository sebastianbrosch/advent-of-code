Get-ChildItem -Path . -Include *.class -File -Recurse | ForEach-Object { $_.Delete() }
Get-ChildItem -Path . -Include *.exe -File -Recurse | ForEach-Object { $_.Delete() }