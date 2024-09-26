import org.scalatest.funsuite.AnyFunSuite

class PlayerTest extends AnyFunSuite {

  test("Player should have correct marker") {
    val player1 = new Player(1)
    val player2 = new Player(2)

    assert(player1.getMarker === 1)
    assert(player2.getMarker === 2)
  }
}
