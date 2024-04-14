package basics.functions

import scala.jdk.Accumulator

object Fibonacci extends App {
  println("Enter the number for fibonacci: ")
  val fibonacciLimit: Int = scala.io.StdIn.readInt()
  //    println(fibonacciLoop(fibonacciLimit))
  println(fibonacciTailRecursion(fibonacciLimit))

  def fibonacciRecursion(n: Int): Int = {
    if (n == 1)
      0
    else if (n == 2 || n == 3)
      1
    else
      fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2)
  }

  def fibonacciTailRecursion(number: Int, prev: Int = 1, curr: Int = 1): Int = {
    if (number == 1 || number == 2) {
      1
    }
    else if (number == 3) {
      curr + prev
    }
    else {
      fibonacciTailRecursion(number - 1, curr, curr + prev)
    }
  }

  def fibonacciLoop(n: Int): Int = {
    if (n == 1)
      0
    else if (n == 2 || n == 3)
      1
    else {
      var prevNumber = 1
      var currNumber = 1
      for (i <- 4 to n) {
        val result = currNumber + prevNumber
        prevNumber = currNumber
        currNumber = result

      }
      currNumber
    }
  }
}
