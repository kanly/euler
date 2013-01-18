package euler

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
object Problem1 {

  def divisibleBy3And5(upperBound: Int): Stream[Int] = {
    Stream.range(0, upperBound).filter(n => (n % 3 == 0 || n % 5 == 0))
  }

  def sumOfNumbersDivisibleBy3And5MinorOf(upperBound: Int): Int = {
    divisibleBy3And5(upperBound).foldLeft(0)(_ + _)
  }

}
