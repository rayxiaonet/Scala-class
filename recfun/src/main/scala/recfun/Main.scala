package recfun

import scala.collection.immutable.Stack


object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def balanceIter(chars:List[Char],stack:Stack[Char]):Boolean={
      if (chars.isEmpty) stack.isEmpty
      else {
        chars.head match {
          case '(' =>balanceIter(chars.tail,stack.push(chars.head))
          case ')' => {
            if (stack.contains('(')) balanceIter(chars.tail,stack.pop)
            else false
          }
          case _ => balanceIter(chars.tail,stack)

        }
      }
    }
    balanceIter(chars,new Stack[Char])
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    money match {
      case 0  => 1
      case x if x < 0 => 0
      case x if x>=1 && coins.isEmpty => 0
      case _ => countChange(money, coins.tail) + countChange(money - coins.head, coins)

    }
  }
}

