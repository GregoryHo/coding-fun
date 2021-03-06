import java.util.Collections
import java.util.PriorityQueue

class Solution {

  fun lastStoneWeight(stones: IntArray): Int {
    val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())
    for (stone in stones) {
      priorityQueue.add(stone)
    }

    while (priorityQueue.size > 1) {
      val stone1 = priorityQueue.poll()
      val stone2 = priorityQueue.poll()
      if (stone1 != stone2) {
        priorityQueue.add(stone1 - stone2)
      }
    }

    return priorityQueue.peek() ?: 0
  }
}

fun main(args: Array<String>) {
  val solution = Solution()
  println(solution.lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
}
