/**
 * Represents the Tic-Tac-Toe game board.
 * Manages the game state, board display, and win-checking logic.
 */
class Board {

  /** 
   * The board is represented as a map, where the keys are positions (e.g., "a1", "b2") 
   * and the values are 0 (empty), 1 (Player 1's marker), or 2 (Player 2's marker). 
   */
  var board: Map[String, Int] = Map(
    "a3" -> 0, "b3" -> 0, "c3" -> 0,
    "a2" -> 0, "b2" -> 0, "c2" -> 0,
    "a1" -> 0, "b1" -> 0, "c1" -> 0
  )

  /**
   * Displays the current state of the game board in a readable format.
   */
  def displayBoard(): Unit = {
    println(s"${getValue("a3")} | ${getValue("b3")} | ${getValue("c3")}")
    println("--+---+--")
    println(s"${getValue("a2")} | ${getValue("b2")} | ${getValue("c2")}")
    println("--+---+--")
    println(s"${getValue("a1")} | ${getValue("b1")} | ${getValue("c1")}")
  }

  /**
   * Gets the value at the specified position on the board.
   * 
   * @param position The position on the board (e.g., "a1", "b2").
   * @return The player's marker (1 or 2) or a space if the position is empty (0).
   */
  def getValue(position: String): String = {
    board.getOrElse(position, 0) match {
      case 0 => " "
      case x => x.toString
    }
  }

  /**
   * Updates the board with the player's marker if the position is valid and empty.
   * 
   * @param position The position to update (e.g., "a1").
   * @param player The current player making the move.
   * @return True if the move is valid and successful, otherwise false.
   */
  def updateBoard(position: String, player: Player): Boolean = {
    if (board(position) == 0) {
      board = board.updated(position, player.getMarker)
      true
    } else {
      false
    }
  }

  /**
   * Checks if the board is full, meaning there are no more valid moves.
   * 
   * @return True if the board is full, otherwise false.
   */
  def isFull: Boolean = board.values.forall(_ != 0)

  /**
   * Checks if there is a winner based on the current state of the board.
   * A winner is determined when a player has completed a row, column, or diagonal.
   * 
   * @return An Option containing the winning player's number (1 or 2), or None if there is no winner.
   */
  def checkWinner(): Option[Int] = {
    val winningCombinations = List(
      // Rows
      List("a3", "b3", "c3"),
      List("a2", "b2", "c2"),
      List("a1", "b1", "c1"),
      // Columns
      List("a3", "a2", "a1"),
      List("b3", "b2", "b1"),
      List("c3", "c2", "c1"),
      // Diagonals
      List("a3", "b2", "c1"),
      List("c3", "b2", "a1")
    )

    // Check if any winning combination is found
    winningCombinations.collectFirst {
      case positions if positions.map(board).distinct.size == 1 && board(positions.head) != 0 => board(positions.head)
    }
  }
}
