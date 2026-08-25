# Text-Based Adventure Game

This project is a text-based adventure game developed in Java. Players can choose different characters, fight enemies, collect items, and try to save the world of Aetheria.

## Features

- 4 different character classes (Warrior, Assassin, Mage, Healer)
- 5 different locations (Safe House, Ghua Market, Shadow Forest, Dark Caverns, Void Realm Portal)
- 3 different enemy types (Void Minion, Shadow Beast, Void Lord)
- Weapon and armor system
- Money system
- Rare item collection system
- Health regeneration system
- Game save/load system

## Requirements

- Java 17 or higher

## Build and run

1. Clone the project:

```bash
git clone https://github.com/Erwinya/Simple-Text-Based-Adventure-Engine.git
cd Simple-Text-Based-Adventure-Engine
```

2. Compile and run (Linux/macOS/Git Bash):

```bash
chmod +x build.sh
./build.sh
```

Or manually:

```bash
mkdir -p bin
find src -name "*.java" ! -name "*Test.java" > sources.txt
javac -d bin @sources.txt
java -cp bin com.halukkilincer.adventure.launcher.Main
```

On Windows (PowerShell), from the project root:

```powershell
New-Item -ItemType Directory -Force bin | Out-Null
Get-ChildItem -Recurse src -Filter *.java | Where-Object { $_.Name -notlike '*Test.java' } | ForEach-Object { $_.FullName } | Set-Content sources.txt
javac -d bin @sources.txt
java -cp bin com.halukkilincer.adventure.launcher.Main
```

## Project structure

```text
src/com/halukkilincer/adventure/
├── characters/    # Character classes
├── items/         # Item system
├── launcher/      # Game entry point (Main)
├── map/           # Game locations
└── utils/         # Location helpers and game utilities
```

## Game controls

- Use numbers 1-4 to navigate menus
- Use S, A, B, H keys for character selection
- During combat:
  - Press V to attack
  - Press K to run away

## License

This project is licensed under the MIT License. See the `LICENSE` file for more information.
