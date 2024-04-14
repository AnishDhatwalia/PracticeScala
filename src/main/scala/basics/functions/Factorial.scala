package basics.functions

object Factorial extends App{

  println(factorial(5))
  def factorial(n: Int): Int = {
    def factorialTailRecursion(n: Int, accumulator: Int):Int = {
      if (n <= 1)
        accumulator
      else {
        factorialTailRecursion(n - 1, accumulator * n)
      }
    }
    factorialTailRecursion(n,1)
  }


}
