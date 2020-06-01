import java.util.PriorityQueue

class Solution {

  fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val counts = HashMap<Int, Int>()
    for (num in nums) {
      counts[num] = counts.getOrDefault(num, 0) + 1
    }

    val priorityQueue = PriorityQueue<Int>(Comparator { o1, o2 -> 
      counts[o2]!! - counts[o1]!!
    })

    for (key in counts.keys) {
      priorityQueue.add(key)
    }

    val answer = IntArray(k)
    var i = 0
    while (i < k) {
      answer[i] = priorityQueue.poll()
      i++
    }

    return answer
  }
}

fun main(args: Array<String>) {
  val solution = Solution()
  println(solution.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).contentToString())
  println(solution.topKFrequent(intArrayOf(1), 1).contentToString())
}
