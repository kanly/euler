package euler

object Common {
  def ints(n: BigInt): Stream[BigInt] = Stream.cons(n, ints(n + 1))

  def primes(nums: Stream[BigInt]): Stream[BigInt] = Stream.cons(nums.head, primes((nums tail) filter (x => x % nums.head != BigInt(0))))

  lazy val cachedPrimes = primes(ints(BigInt(2)))

  def factors(n: BigInt): Stream[BigInt] = cachedPrimes.takeWhile(v => v * v <= n).filter(v => n % v == 0)

  def lazierFactors(n: BigInt): List[BigInt] =
    if (n == 1) Nil
    else {
      val factor = factors(n).headOption.getOrElse(n)
      factor :: lazierFactors(n / factor)
    }
}
