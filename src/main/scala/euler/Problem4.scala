package euler


/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91  99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
object Problem4 {
  def isPalindrome(str: String): Boolean = str match {
    case s if str == null => true
    case s if str.isEmpty => true
    case s if (str.size == 1) => true
    case _ => str.head == str.last && isPalindrome(str.tail.init)
  }

  def maxPalindromeProduct(maxFactor: BigInt): String = {
    def searchPalindromes(a: BigInt, b: BigInt): List[String] = {
      val product = (a * b).toString()
      println("trying " + a + "*" + b + "="+product)
      if (a == 1) List()
      else if (isPalindrome(product)) product :: searchPalindromes(a - 1, maxFactor)
      else if (b == 1) searchPalindromes(a - 1, maxFactor)
      else searchPalindromes(a, b - 1)
    }
    searchPalindromes(maxFactor, maxFactor).sortWith(BigInt(_)<BigInt(_)).last
  }
}
