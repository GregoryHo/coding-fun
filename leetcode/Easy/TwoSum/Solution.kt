class Solution {

  fun twoSum(nums: IntArray, target: Int): IntArray {
    // return twoLoop(nums, target)
    return oneLoopWithHashTable(nums, target)
  }

  // O(N^2)
  fun twoLoop(nums: IntArray, target: Int): IntArray {
    nums.forEachIndexed loop1@{ i, item1 -> 
      val delta = target - item1
      nums.forEachIndexed loop2@{ j, item2 ->
        if (i == j) {
          return@loop2
        }

        if (item2 == delta) {
          return intArrayOf(i, j)
        }
      }
    }

    return intArrayOf()
  }

  // O(N)
  fun oneLoopWithHashTable(nums: IntArray, target: Int): IntArray {
    val valueMap = hashMapOf<Int, Int>()
    nums.forEachIndexed { index, value ->
      val delta = target - value
      if (valueMap[delta] != null) {
        return intArrayOf(valueMap[delta]!!, index)
      }

      valueMap[value] = index
    }

    return intArrayOf()
  }
}

fun main(args: Array<String>) {
  println(Solution().twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString())
  println(Solution().twoSum(intArrayOf(3, 2, 4), 6).contentToString())
}
