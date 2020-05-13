class Solution {

  fun sortColors(nums: IntArray): Unit {
    val length = nums.size
    if (length <= 1) {
      return
    }

    var leftIndex = 0
    var rightIndex = length - 1
    var i = 0
    while (i <= rightIndex) {
      val value = nums[i]
      when (value) {
        0 -> {
          if (i > leftIndex) {
            swap(nums, i, leftIndex)
            leftIndex++
          } else {
            i++
          }
        }
        1 -> i++
        2 -> {
          if (i < rightIndex) {
            swap(nums, i, rightIndex)
            rightIndex--
          } else {
            i++
          }
        }
      }
    }

    println(nums.contentToString())
  }

  private fun swap(nums: IntArray, sourceIndex: Int, destinationIndex: Int): Unit {
    val temp = nums[destinationIndex]
    nums[destinationIndex] = nums[sourceIndex]
    nums[sourceIndex] = temp
  }
}

fun main(args: Array<String>) {
  val solution = Solution()
  solution.sortColors(intArrayOf(2, 0, 2, 1, 1, 0))
}
