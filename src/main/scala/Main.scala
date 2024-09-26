/**
 * The main entry point for the Tic-Tac-Toe game.
 * Instantiates the game and starts the play loop.
 */
object Main {

  /**
   * Main method that launches the Tic-Tac-Toe game.
   * 
   * @param args Command line arguments (not used in this game).
   */
  def main(args: Array[String]): Unit = {
    val game = new Game()
    game.play()
  }
}
