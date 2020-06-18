import java.util.*

class Solution {
  
  fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    return bfs(root)
  }

  fun bfs(root: TreeNode?): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()
    if (root == null) {
      return answer
    }

    var zigzagFlag = false
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
      val list = mutableListOf<Int>()
      var size = queue.size
      while (size > 0) {
        val currentNode = queue.poll()
        currentNode.left?.run {
          queue.add(this)
        }

        currentNode.right?.run {
          queue.add(this)
        }

        list.add(currentNode.`val`)
        size--
      }

      if (zigzagFlag) {
        Collections.reverse(list)
      }

      zigzagFlag = !zigzagFlag
      answer.add(list)
    }
    
    return answer
  }
}

class TreeNode(val `val`: Int) {

  var left: TreeNode? = null
  var right: TreeNode? = null
}

fun main(args: Array<String>) {
  val solution = Solution()
  val node1 = TreeNode(3).apply {
    left = TreeNode(9)
    right = TreeNode(20).apply {
      left = TreeNode(15)
      right = TreeNode(7)
    }
  }

  println(solution.zigzagLevelOrder(node1))
}
