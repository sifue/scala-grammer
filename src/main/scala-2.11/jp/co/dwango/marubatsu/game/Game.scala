package jp.co.dwango.marubatsu.game

import jp.co.dwango.marubatsu.board.Board

class Game(private[this] val winner: Winner, private[this] val board: Board) {

  def play(row: Int, column: Int): Game = {
    if (board.canPut(row, column)) {
      val nextBoard = board.put(row, column)
      new Game(judgeWinner(nextBoard), nextBoard)
    } else {
      this
    }
  }

  private[this] def judgeWinner(board: Board): Winner = {
    val winPattern =
      Seq(((0, 0), (0, 1), (0, 2)), ((1, 0), (1, 1), (1, 2)), ((2, 0), (2, 1), (2, 2)),
        ((0, 0), (1, 0), (2, 0)), ((0, 1), (1, 1), (2, 1)), ((0, 2), (1, 2), (2, 2)),
        ((0, 0), (1, 1), (2, 2)), ((2, 0), (1, 1), (0, 2)))

    val cells = board.cells

    val winners = winPattern.map {
      case (c1, c2, c3) if cells(c1) == cells(c2) && cells(c2) == cells(c3) => toWinner(cells(c1))
      case _ => NoWinner
    }

    if(winners.contains(Maru)) {
      Maru
    } else if (winners.contains(Batsu)) {
      Batsu
    } else {
      NoWinner
    }
  }

  override def toString = s"Game($winner, $board)"

}

object Game {

  def apply(): Game = new Game(NoWinner, Board())

}
