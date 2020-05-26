class Solution {

  fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val answer = mutableListOf<Int>()  
    val set1 = nums1.toHashSet().sortedWith(Comparator { o1, o2 -> 
      when {
        o1 < o2 -> -1
        o1 == o2 -> 0
        else -> 1
      }
    })
    val set2 = nums2.toHashSet().sortedWith(Comparator { o1, o2 ->
      when {
        o1 < o2 -> -1
        o1 == o2 -> 0
        else -> 1
      }
    })
    var i = 0
    var j = 0
    while (i < set1.size && j < set2.size) {
      if (set1[i] == set2[j]) {
        answer.add(set1[i])
        i++
        j++
      } else if (set1[i] < set2[j]) {
        i++
      } else {
        j++
      }
    }

    return answer.toTypedArray().toIntArray()
  }
}

fun main(args: Array<String>) {
  val solution = Solution()
  println(solution.intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).contentToString())
  println(solution.intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).contentToString())
}
