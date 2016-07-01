package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  def evenNumbers: Set = x => x % 2 == 0
  println(printSet(evenNumbers))
}
