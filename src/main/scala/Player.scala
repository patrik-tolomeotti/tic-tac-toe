/**
 * Represents a player in the Tic-Tac-Toe game.
 * 
 * @param playerNumber The number associated with the player (1 or 2).
 */
class Player(val playerNumber: Int) {

  /**
   * Returns the marker associated with the player.
   * 
   * @return The player's marker, which is the same as their player number (1 or 2).
   */
  def getMarker: Int = playerNumber
}
