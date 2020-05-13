class Solution {

  fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortWith(Comparator<IntArray> { o1, o2 ->
      when {
        o1[0] < o2[0] -> -1
        o1[0] == o2[0] -> 0
        else -> 1
      }
    })

    var index = 0
    val merged = mutableListOf<IntArray>()
    intervals.forEach {
      if (merged.isEmpty() || merged[index - 1][1] < it[0]) {
        merged.add(it)
        index++
      } else {
        merged[index - 1][1] = Math.max(merged[index - 1][1], it[1])
      }
    }

    return merged.toTypedArray()
  }
}

fun main(args: Array<String>) {
  val solution = Solution()
  println(solution.merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))).map { it.contentToString() })
  println(solution.merge(arrayOf(intArrayOf(1, 4), intArrayOf(4, 5))).map { it.contentToString() })
  println(solution.merge(arrayOf(intArrayOf(1, 4), intArrayOf(0, 4))).map { it.contentToString() })
}
