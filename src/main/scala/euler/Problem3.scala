package euler

import Common._


/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
object Problem3 {



  def largestFactor(n: BigInt): BigInt = {
    val start = System.currentTimeMillis()
    val res = lazierFactors(n).last
    println("executed in: "+(System.currentTimeMillis()-start))
    res
  }
}
