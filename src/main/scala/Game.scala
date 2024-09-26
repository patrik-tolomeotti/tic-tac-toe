import scala.io.StdIn.readLine

/**
 * Represents the Tic-Tac-Toe game.
 * Manages the game loop, player turns, and overall game logic.
 */
class Game {

  /** The game board. */
  val board = new Board()

  /** An array containing two players, Player 1 and Player 2. */
  val players = Array(new Player(1), new Player(2))

  /** Keeps track of the current player's turn (0 for Player 1, 1 for Player 2). */
  var currentTurn: Int = 0 // Player 1 starts

  /**
   * Switches the current turn between the two players.
   */
  def switchTurn(): Unit = {
    currentTurn = 1 - currentTurn
  }

  /**
   * Runs the main game loop, allowing players to take turns making moves until 
   * there is a winner or the board is full (resulting in a draw).
   */
  def play(): Unit = {
    println("Welcome to Tic-Tac-Toe!")

    var gameOver = false
    while (!gameOver) {
      board.displayBoard()
      val currentPlayer = players(currentTurn)
      println(s"Player ${currentPlayer.playerNumber}'s turn.")

      // Get player input
      val position = readLine("Enter position (e.g., a1, b2, c3): ").toLowerCase

      // Validate and update the board
      if (board.board.contains(position) && board.updateBoard(position, currentPlayer)) {
        board.checkWinner() match {
          case Some(winner) =>
            board.displayBoard()
            println(s"Player $winner wins!")
            gameOver = true
          case None =>
            if (board.isFull) {
              board.displayBoard()
              println("It's a draw!")
              gameOver = true
            } else {
              switchTurn() // Switch turns after a valid move
            }
        }
      } else {
        println("Invalid move. Try again.")
      }
    }
  }
}
