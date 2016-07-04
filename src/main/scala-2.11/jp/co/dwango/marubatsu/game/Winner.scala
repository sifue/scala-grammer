package jp.co.dwango.marubatsu.game

import jp.co.dwango.marubatsu.field.{Batsu, CellState, Maru}

sealed trait Winner

case object NonePlayer extends Winner

case object MaruPlayer extends Winner

case object BatsuPlayer extends Winner

object Winner {

  def toWinner(cellState: CellState): Winner = cellState match {
    case Maru => MaruPlayer
    case Batsu => BatsuPlayer
    case _ => NonePlayer
  }

}