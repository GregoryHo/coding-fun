class Solution {

  fun longestPalindrome(s: String): String {
    if (s.isEmpty()) {
      return s
    }

    val length = s.length
    val dp = Array(length) { BooleanArray(length) }
    var startIndex = 0
    var endIndex = 0
    val chars = s.toCharArray()
    for (i in length - 1 downTo 0) {
      for (j in i until length) {
        if (j - i <= 2) {
          dp[i][j] = chars[i] == chars[j]
        } else {
          dp[i][j] = dp[i + 1][j - 1] && chars[i] == chars[j]
        }

        if (dp[i][j] && endIndex - startIndex <= j - i) {
          startIndex = i
          endIndex = j
        }
      }
    }

    return s.substring(startIndex, endIndex + 1)
  }

fun main(args: Array<String>) {
  val solution = Solution()
  println(solution.longestPalindrome("babad"))
  println(solution.longestPalindrome("cbbd"))
  println(solution.longestPalindrome("a"))
  println(solution.longestPalindrome("ac"))
  println(solution.longestPalindrome("ccc"))
  println(solution.longestPalindrome("abcda")) 
  println(solution.longestPalindrome("abcba")) 
  println(solution.longestPalindrome("caba"))
  println(solution.longestPalindrome("eabcb"))
  println(solution.longestPalindrome("aaabaaaa"))
}
