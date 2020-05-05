class Solution {

  fun threeSum(nums: IntArray): List<List<Int>> {
    val size = nums.size
    val sortedNums = nums.sorted()
    val answers = mutableListOf<List<Int>>()
    if (size < 3) {
      return answers
    }

    for (i in 0 until size - 2) {
      var leftIndex = i + 1
      var rightIndex = size - 1
      val num = sortedNums[i]
      if (i > 0 && num == sortedNums[i - 1]) {
        continue
      }
      
      while (leftIndex < rightIndex) {
        val leftNum = sortedNums[leftIndex]
        val rightNum = sortedNums[rightIndex]
        val sum = leftNum + rightNum
        if (num + sum == 0) {
          answers.add(listOf(num, leftNum, rightNum))
          // skip left value which the same as previous
          while (leftIndex < rightIndex && leftNum == sortedNums[leftIndex + 1]) { 
            leftIndex++
          }

          leftIndex++ 
          // skip right value which the same as previous
          while (rightIndex > leftIndex && rightNum == sortedNums[rightIndex - 1]) {
            rightIndex--
          }
          
          rightIndex--
        } else if (-num > sum) {
          leftIndex++
        } else {
          rightIndex--
        }
      }
    }

    return answers 
  }
}

fun main(args: Array<String>) {
  val solution = Solution()
  println(solution.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))) // -4, -1, -1, 0, 1, 2
  println(solution.threeSum(intArrayOf()))
  println(solution.threeSum(intArrayOf(0, 0)))
  println(solution.threeSum(intArrayOf(0, 0, 0)))
  println(solution.threeSum(intArrayOf(-2, 0, 1, 1, 2)))
  println(solution.threeSum(intArrayOf(0, 0, 0, 0)))
  println(solution.threeSum(intArrayOf(3, 0, -2, -1, 1, 2)))
  println(solution.threeSum(intArrayOf(-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6)))
  println(solution.threeSum(intArrayOf(1, -1, -1, 0)))
}
