import java.util.Collections
import java.util.PriorityQueue

class Solution {

  fun findKthLargest(nums: IntArray, k: Int): Int {
    val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())
    for (num in nums) {
      priorityQueue.add(num)
    }
    
    var i = 0
    while (i < k - 1) {
      priorityQueue.poll()
      i++
    }

    return priorityQueue.peek()
  }
}

fun main(args: Array<String>) {
  val solution = Solution()
  println(solution.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
  println(solution.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
}
