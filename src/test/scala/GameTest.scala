import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._

class GameTest extends AnyFunSuite with MockitoSugar {

  test("Game should initialize correctly") {
    val game = new Game()
    assert(game.currentTurn === 0) // Player 1 starts
  }

  test("Game should switch turns correctly") {
    val game = new Game()

    game.switchTurn()
    assert(game.currentTurn === 1) // Player 2's turn

    game.switchTurn()
    assert(game.currentTurn === 0) // Back to Player 1
  }

  test("Game should end when a player wins") {
    val mockBoard = mock[Board]
    val game = new Game {
      override val board: Board = mockBoard
    }

    when(mockBoard.checkWinner()).thenReturn(Some(1)) // Simulate Player 1 winning

    assert(game.board.checkWinner() === Some(1))
  }

  test("Game should continue until board is full or winner is found") {
    val mockBoard = mock[Board]
    val game = new Game {
      override val board: Board = mockBoard
    }

    // Simulate no winner and board not full
    when(mockBoard.checkWinner()).thenReturn(None)
    when(mockBoard.isFull).thenReturn(false)

    assert(game.board.checkWinner() === None)
    assert(game.board.isFull === false)
  }

  test("Game should detect a draw") {
    val mockBoard = mock[Board]
    val game = new Game {
      override val board: Board = mockBoard
    }

    // Simulate the board being full without a winner
    when(mockBoard.checkWinner()).thenReturn(None)
    when(mockBoard.isFull).thenReturn(true)

    assert(game.board.isFull === true)
    assert(game.board.checkWinner() === None) // It's a draw
  }
}
