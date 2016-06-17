/**
  * Created by soichiro_yoshimura on 2016/06/17.
  */
class Dog(name: String) {

  def greet(): Unit = println(s"${name}だワン")

}

object Taro extends Dog("タロウ")

object Dog {

  def apply(name: String) = new Dog(name)

  def apply(id: Int) = new Dog(s"番号付き犬${id}番")

}