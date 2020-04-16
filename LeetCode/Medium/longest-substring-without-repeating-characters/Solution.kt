class Solution {

  fun lengthOfLongestSubstring(s: String): Int {
    return concatString(s)
  }

  // O(N)
  fun concatString(s: String): Int {
    var longestSubstring = ""
    var concatString = ""
    s.toCharArray().forEach { 
      if (!concatString.contains(it)) {
        concatString+=it
      } else {
        if (concatString.length > longestSubstring.length) {
          longestSubstring = concatString
        }

        concatString = concatString.substring(concatString.indexOf(it) + 1) + it
      }
    }

    if (concatString.length > longestSubstring.length) {
      longestSubstring = concatString 
    }

    return longestSubstring.length
  }
}

fun main(args: Array<String>) {
  println(Solution().lengthOfLongestSubstring("abcabcbb"))
  println(Solution().lengthOfLongestSubstring("bbbbb"))
  println(Solution().lengthOfLongestSubstring("pwwkew"))
  println(Solution().lengthOfLongestSubstring(" "))
  println(Solution().lengthOfLongestSubstring("dvdf"))
}
