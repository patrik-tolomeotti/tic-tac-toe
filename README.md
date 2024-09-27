# Tic-Tac-Toe Game

## Project for Betsson Group Interview

This project is a Scala implementation of the classic Tic-Tac-Toe game. It was developed as part of an interview process with Betsson Group, showcasing skills in object-oriented design, unit testing, and Scala programming.

### Table of Contents
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [Running Tests](#running-tests)
- [Building a Fat JAR](#building-a-fat-jar)
- [Running the Executable JAR](#running-the-executable-jar)

---

## Project Structure

The project follows a standard Scala SBT structure with source code, test cases, and configurations organized in separate directories.

```bash
tic-tac-toe/
├── build.sbt               # SBT configuration file
├── project/
│   └── plugins.sbt         # SBT plugins (including sbt-assembly)
├── src/
│   ├── main/
│   │   └── scala/
│   │       ├── Board.scala     # Board logic
│   │       ├── Game.scala      # Game class
│   │       └── Main.scala     
│   │       └── Player.scala    # Player logic
│   └── test/
│       └── scala/
│           ├── GameTest.scala      # Unit tests for the game
│           └── BoardTest.scala     # Unit tests for the board
│           └── PlayerTest.scala    # Unit tests for the player
└── README.md                       # Project documentation (this file)
```

## How to Run
### Prerequisites

- Java (JDK 8 or higher)
- SBT (Scala Build Tool) installed on your machine

1. Clone the Repository:

```bash
git clone https://github.com/patrik-tolomeotti/tic-tac-toe.git
cd tic-tac-toe
```

2. Compile the Project: In the root directory of the project, run:

```bash
sbt compile
```

3. Run the Game: To start the game, use the following command:

```bash
sbt run
```

## Running Tests

The project includes unit tests for the **Game** and **Board** classes. To run the tests, use the following command:

```bash
sbt test
```

The test suite covers all critical functionalities, including:

- Checking for a winner.
- Ensuring valid moves.
- Detecting draws.

## Building a Fat JAR

To package the application into a fat JAR (an executable JAR that includes all dependencies), use **sbt-assembly**:

1. Ensure that the **sbt-assembly** plugin is installed (it is already included in the **project/plugins.sbt** file).
2. Build the JAR:
```bash
sbt assembly
```
This will create a JAR file under the **target/scala-2.13/** directory.

## Running the Executable JAR

Once you have built the fat JAR, you can run it on any machine that has Java installed.

1. Navigate to the **target/scala-2.13/** directory:
```bash
cd target/scala-2.13/
```
2. Run the JAR file:
```bash
java -jar tic-tac-toe-assembly-0.1.jar
```