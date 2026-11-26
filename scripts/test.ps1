$ErrorActionPreference = "Stop"

$projectRoot = Split-Path -Parent $PSScriptRoot
$outputDirectory = Join-Path $projectRoot "build\test-classes"

Remove-Item -Recurse -Force $outputDirectory -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Force $outputDirectory | Out-Null

$sourceFiles = @(
    Get-ChildItem -Path (Join-Path $projectRoot "src"), (Join-Path $projectRoot "test") `
        -Recurse -Filter *.java |
        ForEach-Object { $_.FullName }
)

& javac -encoding UTF-8 -d $outputDirectory @sourceFiles
if ($LASTEXITCODE -ne 0) {
    throw "Compilation failed with exit code $LASTEXITCODE"
}

$tests = @(
    "com.halukkilincer.adventure.items.InventoryTest",
    "com.halukkilincer.adventure.utils.GameSaveManagerTest"
)

foreach ($test in $tests) {
    & java -ea -cp $outputDirectory $test
    if ($LASTEXITCODE -ne 0) {
        throw "$test failed with exit code $LASTEXITCODE"
    }
}

Write-Host "All tests passed."
