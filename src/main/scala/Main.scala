import org.scalactic.TypeCheckedTripleEquals.convertToCheckingEqualizer

import scala.annotation.tailrec

object Main {

  def factorial(n: Int): Long = if (n <= 1) 1 else n * factorial(n-1)

  def factorialTailRec(n: Int): Long = {
    require(n > 0)
    @tailrec
    def factorialAcc(acc: Long, i: Int): Long = {
      if (i <= 1) acc else factorialAcc(acc * i, i -1)
    }
    factorialAcc(1, n)
  }

  @tailrec
  def isPalindromeTailRec(s: String): Boolean = {
    require(s != null)
    if (s.isEmpty || s.length == 1)
      true
    else if (s.charAt(0) != s.charAt(s.length-1))
      false
    else
      isPalindromeTailRec(s.tail.substring(s.length-1))
  }

  def fibUsingSimpleRecursion(n: Int): Int = {
    require(n >= 0)
    if (n == 0)
      0
    else if (n == 1)
      1
    else
      fibUsingSimpleRecursion(n-1) + fibUsingSimpleRecursion(n-2)
  }

  def fibUsingTailRec(n: Int): Int = {
    require(n >= 0)

    @tailrec
    def fibWithAcc(i: Int, acc: List[Int]): Int = {
      val nextValue = acc.head + acc.tail.head
      if (i == 2)
        nextValue
      else {
        fibWithAcc(i - 1, nextValue :: acc)
      }
    }


    if (n == 0)
      0
    else if (n == 1)
      1
    else
      fibWithAcc(n, List(1, 0)) // List(F(1), F(0))

  }
  def main(args: Array[String]): Unit = {
    println(factorial(10)) // Expected: 3628800
    println(factorialTailRec(10)) // Expected: 3628800
    println(isPalindromeTailRec("abcdedcba")) // Expected: true
    println(isPalindromeTailRec("abcdedcbae")) // Expected: false
    val n = 31 // Expected: 1,346,269
    println(s"${n}: ${fibUsingSimpleRecursion(n)}")
    println(s"${n}: ${fibUsingTailRec(n)}")

    assert(Main.fibUsingSimpleRecursion(0) == 0)
    assert(Main.fibUsingSimpleRecursion(1) == 1)
    assert(Main.fibUsingSimpleRecursion(2) == 1)
    assert(Main.fibUsingSimpleRecursion(3) == 2)
    assert(Main.fibUsingSimpleRecursion(23) == 28657)
    assert(Main.fibUsingTailRec(0) == 0)
    assert(Main.fibUsingTailRec(1) == 1)
    assert(Main.fibUsingTailRec(2) == 1)
    assert(Main.fibUsingTailRec(3) == 2)
    assert(Main.fibUsingTailRec(23) == 28657)
  }
}