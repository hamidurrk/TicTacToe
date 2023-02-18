# Tic Tac Toe
This is a simple implementation of the classic Tic Tac Toe game in Java using Swing for the graphical user interface. The game allows two players to take turns marking spaces on a 3x3 grid in order to get three in a row and win the game.

## Getting Started
### Prerequisites
- Java Development Kit (JDK) 8 or later
- Apache Maven (optional)
### Installing
- Clone the repository: git clone https://github.com/your-username/tic-tac-toe-java.git
- Build the project:
- If using Maven: mvn package
- If not using Maven: javac TicTacToe.java
- Run the game: java -cp target/tic-tac-toe-java-1.0.jar TicTacToe
### Usage
The game is played by two players taking turns clicking on the empty spaces on the game board in order to place their symbol (either X or O) in that space. The first player to get three symbols in a row, either horizontally, vertically, or diagonally, wins the game.

If there are no more empty spaces on the game board and no player has won, the game ends in a tie.

To start a new game after a game has ended, simply click on any of the spaces on the game board and the board will be reset.

### Built With
- Java
- Swing
