import org.scalatest.funsuite.AnyFunSuite

class BoardTest extends AnyFunSuite {

  test("Board should be initialized with empty spaces") {
    val board = new Board()

    for (pos <- board.board.keys) {
      assert(board.board(pos) === 0)
    }
  }

  test("Board should correctly display value at each position") {
    val board = new Board()
    val player = new Player(1)
    board.updateBoard("a1", player)

    assert(board.getValue("a1") === "1")
    assert(board.getValue("b2") === " ")
  }

  test("Board should correctly update with player's move") {
    val board = new Board()
    val player1 = new Player(1)
    val player2 = new Player(2)

    assert(board.updateBoard("a1", player1) === true)
    assert(board.board("a1") === 1)

    assert(board.updateBoard("a1", player2) === false) // Can't overwrite an occupied position
    assert(board.board("a1") === 1) // Remains as Player 1's marker
  }

  test("Board should detect if it is full") {
    val board = new Board()
    val player = new Player(1)

    for (pos <- board.board.keys) {
      board.updateBoard(pos, player)
    }

    assert(board.isFull === true)
  }

  test("Board should detect a winner") {
    val board = new Board()
    val player1 = new Player(1)
    board.updateBoard("a1", player1)
    board.updateBoard("b1", player1)
    board.updateBoard("c1", player1)

    assert(board.checkWinner() === Some(1)) // Player 1 should win
  }

  test("Board should detect no winner") {
    val board = new Board()
    val player1 = new Player(1)
    val player2 = new Player(2)

    board.updateBoard("a1", player1)
    board.updateBoard("b1", player2)
    board.updateBoard("c1", player1)

    assert(board.checkWinner() === None) // No winner in this configuration
  }
}
