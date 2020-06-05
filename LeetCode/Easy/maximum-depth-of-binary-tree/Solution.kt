import java.util.*

class Solution {

  fun maxDepth(root: TreeNode?): Int {
    // return bfs(root)
    return dfs(root)
  }

  // time complexity O(N)
  // space complexity O(N/2)
  private fun bfs(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }

    var depth = 0
    val stack = Stack<TreeNode>()
    val depths = Stack<Int>()
    stack.add(root)
    depths.add(1)
    while (!stack.isEmpty()) {
      val currentNode = stack.pop()
      val currentDepth = depths.pop()
      if (currentNode.left != null) {
        depths.add(currentDepth + 1)
        stack.add(currentNode.left!!)
      }

      if (currentNode.right != null) {
        depths.add(currentDepth + 1)
        stack.add(currentNode.right!!)
      }

      depth = Math.max(depth, currentDepth)
    }

    return depth
  }

  // time complexity O(N)
  // space complexity O(N)
  private fun dfs(root: TreeNode?): Int {
    return root?.run { 
      Math.max(dfs(root.left), dfs(root.right)) + 1
    } ?: 0
  }
}

class TreeNode(var value: Int) {

  var left: TreeNode? = null
  var right: TreeNode? = null
}

fun main(args: Array<String>) {
  val solution = Solution()
  val node = TreeNode(3).apply {
    left = TreeNode(9)
    right = TreeNode(20).apply {
      left = TreeNode(15)
      right = TreeNode(7)
    }
  }

  println(solution.maxDepth(node))
}
