# Backup location
$location = "M:\FileHistory\ferna\DESKTOP-3VEGAHM (4)\Data\C\Users\ferna\Downloads"

# move to the location
Set-Location $location
# list all items
$files = @(Get-ChildItem)
Write-Output $files | Select-Object name

# take me back to the C drive
Set-Location "C:\Users\ferna\Desktop\"
