package jp.co.dwango.marubatsu.game

import jp.co.dwango.marubatsu.field.Field

class Game(private[this] var field: Field) {

  def play(row: Int, column: Int): GameState = {
    if (field.canPut(row, column)) {
      field = field.put(row, column)
    }
    GameState(judgeWinner(), field)
  }

  def currentField: Field = field

  private def judgeWinner(): Winner = {
    val winPattern: Seq[((Int, Int), (Int, Int), (Int, Int))] =
      (for (i <- 0 to 2) yield ((i, 0), (i, 1), (i, 2))) ++
        (for (i <- 0 to 2) yield ((0, i), (1, i), (2, i))) ++
        Seq(((0, 0), (1, 1), (2, 2)), ((2, 0), (1, 1), (0, 2)))

    val cells = field.cells

    val winners = winPattern.map {
      case (c1, c2, c3) if cells(c1) == cells(c2) && cells(c2) == cells(c3) => Winner.toWinner(cells(c1))
      case _ => NonePlayer
    }

    if(winners.contains(MaruPlayer)) {
      MaruPlayer
    } else if (winners.contains(BatsuPlayer)) {
      BatsuPlayer
    } else {
      NonePlayer
    }
  }

}

case class GameState(winner: Winner, field: Field)

object Game {

  def apply(): Game = new Game(Field())
  
}
