/**
  * Created by soichiro_yoshimura on 2016/06/13.
  */
object RPG {

}

abstract class Creature(var hitPoint: Int, var attackDamage: Int) {
  def isAlive(): Boolean = this.hitPoint > 0
}

class Hero(_hitPoint: Int, _attackDamage: Int) extends Creature(_hitPoint, _attackDamage) {

  def attack(monster: Monster): Unit = ???

  def escape(monster: Monster): Boolean = ???

  override def toString = s"Hero(体力: ${hitPoint}, 攻撃力:${attackDamage})"

}

class Monster(_hitPoint: Int, _attackDamage: Int, var isAwayFromHero: Boolean)
  extends  Creature(_hitPoint, _attackDamage) {

  override def toString = s"Monster(体力: ${hitPoint}, 攻撃力:${attackDamage})"

}