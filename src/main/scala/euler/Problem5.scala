package euler

import Common._

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
object Problem5 {
  def smallestNumberDivisibleForAllNumbersLessThan(n: Int) =
    (1 until n).foldLeft(List[BigInt]())((facts, num) => facts ++ lazierFactors(num).diff(facts).toList).fold(BigInt(1))(_ * _)
}
