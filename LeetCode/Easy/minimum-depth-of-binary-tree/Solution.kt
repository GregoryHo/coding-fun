class Solution {

  fun minDepth(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }

    return dfs(root)
  }

  private fun dfs(root: TreeNode?): Int {
    if (root == null) {
      return Integer.MAX_VALUE
    }

    if (root.left == null && root.right == null) {
      return 1
    }

    val leftHeight = dfs(root.left)
    val rightHeight = dfs(root.right)
    return Math.min(leftHeight, rightHeight) + 1
  }
}

class TreeNode(`val`: Int) {

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

  val node2 = TreeNode(1).apply {
    left = TreeNode(2)
  }

  println(solution.minDepth(node1))
  println(solution.minDepth(node2))
}
