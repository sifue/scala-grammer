package jp.co.dwango.marubatsu.game

import jp.co.dwango.marubatsu.board.Board

class Game(private[this] var board: Board) {

  def play(row: Int, column: Int): GameState = {
    if (board.canPut(row, column)) {
      board = board.put(row, column)
    }
    GameState(judgeWinner(), board)
  }

  private[this] def judgeWinner(): Winner = {
    val winPattern: Seq[((Int, Int), (Int, Int), (Int, Int))] =
      (for (i <- 0 to 2) yield ((i, 0), (i, 1), (i, 2))) ++
        (for (i <- 0 to 2) yield ((0, i), (1, i), (2, i))) ++
        Seq(((0, 0), (1, 1), (2, 2)), ((2, 0), (1, 1), (0, 2)))

    val cells = board.cells

    val winners = winPattern.map {
      case (c1, c2, c3) if cells(c1) == cells(c2) && cells(c2) == cells(c3) => toWinner(cells(c1))
      case _ => None
    }

    if(winners.contains(Maru)) {
      Maru
    } else if (winners.contains(Batsu)) {
      Batsu
    } else {
      None
    }
  }

}

case class GameState(winner: Winner, board: Board)

object Game {

  def apply(): Game = new Game(Board())

}
