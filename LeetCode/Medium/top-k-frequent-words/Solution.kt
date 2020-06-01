import java.util.PriorityQueue

class Solution {

  fun topKFrequent(words: Array<String>, k: Int): List<String> {
    val counts = HashMap<String, Int>()
    for (word in words) {
      counts[word] = counts.getOrDefault(word, 0) + 1
    }

    val priorityQueue = PriorityQueue<String>(Comparator { o1, o2 ->
      if (counts[o1] == counts[o2]) {
        o1.compareTo(o2)
      } else {
        counts[o2]!! - counts[o1]!!
      }
    })

    
    for (key in counts.keys) {
      priorityQueue.add(key)  
    }

    val answer = mutableListOf<String>()
    var i = 0
    while (i < k) {
      answer.add(priorityQueue.poll())
      i++
    }

    return answer
  }
}

fun main(args: Array<String>) {
  val solution = Solution()
  println(solution.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2))
  println(solution.topKFrequent(arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), 4))
}
