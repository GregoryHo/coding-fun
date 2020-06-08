class Solution {
  
  fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return dfs(nums, 0, nums.size - 1)
  }

  private fun dfs(nums: IntArray, startIndex: Int, endIndex: Int): TreeNode? {
    if (startIndex > endIndex) {
      return null
    }

    val midIndex = (startIndex + endIndex) / 2
    return TreeNode(nums[midIndex]).apply {
      left = dfs(nums, startIndex, midIndex - 1)
      right = dfs(nums, midIndex + 1, endIndex)
    }
  }
}

class TreeNode(val value: Int) {
  
  var left: TreeNode? = null
  var right: TreeNode? = null

  override fun toString(): String {
    return "[$value] -> L $left -> R ${right}"
  }
}

fun main(args: Array<String>) {
  val solution = Solution()
  println(solution.sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9)))
}
