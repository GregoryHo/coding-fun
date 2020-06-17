class Solution {

  fun isBalanced(root: TreeNode?): Boolean {
    return dfs(root).balanced
  }

  private fun dfs(root: TreeNode?): NodeStatus {
    if (root == null) {
      return NodeStatus(true, 0)
    }

    val leftNodeStatus = dfs(root.left)
    // just interupt when one subtree is not balanced
    if (!leftNodeStatus.balanced) {
      return leftNodeStatus
    }

    // just interupt when one subtree is not balanced
    val rightNodeStatus = dfs(root.right)
    if (!rightNodeStatus.balanced) {
      return rightNodeStatus
    }

    return NodeStatus(Math.abs(leftNodeStatus.height - rightNodeStatus.height) <= 1, Math.max(leftNodeStatus.height, rightNodeStatus.height) + 1)
  }
}

data class NodeStatus(val balanced: Boolean, val height: Int)

class TreeNode(var `val`: Int) {

  var left: TreeNode? = null
  var right: TreeNode? = null

  override fun toString(): String {
    return "[$`val`] -> L $left -> R $right"
  }
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

  val node2 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(3).apply {
        left = TreeNode(4)
        right = TreeNode(4)
      }

      right = TreeNode(3)
    }
    
    right = TreeNode(2)
  }

  println(solution.isBalanced(node1))
  println(solution.isBalanced(node2))
}
