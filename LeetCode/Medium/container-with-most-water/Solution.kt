class Solution {

  fun maxArea(height: IntArray): Int {
    // return twoLoop(height)
    return twoPointClose(height)
  }

  // O(N^2)
  fun twoLoop(height: IntArray): Int {
    val lastIndex = height.size - 1
    var maximumArea = 0
    height.forEachIndexed { i, valueI -> 
      height.reversedArray().forEachIndexed inside@{ j, valueJ ->
        val realIndex = lastIndex - j
        if (realIndex == i) {
          return@inside
        }

        val y = Math.min(valueI, valueJ)
        maximumArea = Math.max(maximumArea, y * (realIndex - i))
      }
    }

    return maximumArea
  }

  // O(N)
  fun twoPointClose(height: IntArray): Int {
    var i = 0
    var j = height.size - 1
    var maximumArea = 0
    while (i != j) {
      val y = Math.min(height[i], height[j])
      maximumArea = Math.max(maximumArea, y * (j - i))
      if (height[j] > height[i]) {
        i++
      } else {
        j--
      }
    }

    return maximumArea
  }
}

fun main(args: Array<String>) {
  val solution = Solution()
  println(solution.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
  println(solution.maxArea(intArrayOf(1, 1)))
}
