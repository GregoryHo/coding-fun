class Solution {

  fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
      return false
    }

    return sort(s) == sort(t)
  }

  private fun sort(s: String): List<Char> {
    return s.toCharArray().sortedWith(Comparator { o1, o2 -> 
      when {
        o1 < o2 -> -1
        o1 == o2 -> 0
        else -> 1
      }
    })
  }
}

fun main(args: Array<String>) {
  val solution = Solution()
  println(solution.isAnagram("anagram", "nagaram"))
  println(solution.isAnagram("rat", "car"))
}
