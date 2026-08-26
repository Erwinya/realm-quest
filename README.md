# Realm Quest

Realm Quest is a Java console adventure set in Neo-Circuit, a neon megacity controlled by the Helix Corporation. Choose an operative, collect the tools needed to breach the Corp Vault, defeat the Overseer, steal the Core Cipher, and escape before the city locks down.

## Features

- Four playable roles: Enforcer, Ghost, Netrunner, and Medic
- Five locations across Neo-Circuit, from a hidden Safehouse to the Corp Vault
- Turn-based encounters with Street Drones, Chrome Guards, and the Overseer
- Cyberpunk weapons and armor augments purchased with credits
- Mission-item progression through the Data Crystal and Access Key
- Health recovery, character statistics, inventory, and save/load systems

## Requirements

- Java 17 or later

## Build and run

Clone the repository:

```bash
git clone https://github.com/Erwinya/realm-quest.git
cd realm-quest
```

On Linux, macOS, or Git Bash:

```bash
chmod +x build.sh
./build.sh
```

To compile manually:

```bash
mkdir -p bin
find src -name "*.java" ! -name "*Test.java" > sources.txt
javac -d bin @sources.txt
java -cp bin com.halukkilincer.adventure.launcher.Main
```

On Windows PowerShell:

```powershell
New-Item -ItemType Directory -Force bin | Out-Null
Get-ChildItem -Recurse src -Filter *.java |
  Where-Object { $_.Name -notlike '*Test.java' } |
  ForEach-Object { $_.FullName } |
  Set-Content sources.txt
javac -d bin "@sources.txt"
java -cp bin com.halukkilincer.adventure.launcher.Main
```

## How to play

1. Enter an operative codename and select a role with `S`, `A`, `B`, or `H`.
2. Visit the Data District and Undercity Tunnels to recover both breach assets.
3. Upgrade equipment at the Black Market and restore health at the Safehouse.
4. Enter the Corp Vault, defeat the Overseer, and extract the Core Cipher.

Use `F` to engage a hostile group, `A` to attack during combat, and `R` to retreat. Choose option `6` from the run map to save progress.

## Project structure

```text
src/com/halukkilincer/adventure/
├── characters/    # Playable roles and enemies
├── engine/        # Game lifecycle and main loop
├── items/         # Inventory and equipment state
├── launcher/      # Application entry point
├── map/           # Neo-Circuit locations
├── ui/            # Console menus
└── utils/         # Combat, persistence, and shared utilities
```

The project keeps the original package namespace to preserve compatibility with the existing engine.

## License

This project is licensed under the MIT License. See `LICENSE` for details.
