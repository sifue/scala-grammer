package jp.co.dwango.marubatsu.game

sealed abstract class Winner
case object None extends Winner
case object Maru extends Winner
case object Batsu extends Winner