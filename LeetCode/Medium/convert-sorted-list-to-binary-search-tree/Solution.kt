class Solution {
  
  fun sortedListToBST(head: ListNode?): TreeNode? {
    return dfs(head)
  }

  private fun dfs(head: ListNode?): TreeNode? {
    if (head == null) {
      return null
    }

    val mid = findMiddleNode(head)
    return TreeNode(mid.value).apply {
      if (head != mid) {
        left = dfs(head)
        right = dfs(mid.next)
      }
    }
  }
  
  private fun findMiddleNode(head: ListNode): ListNode {
    // three pointer to find middle node
    var previousPointer: ListNode? = null
    var slowPointer: ListNode = head
    var fastPointer: ListNode? = head
    while (fastPointer != null && fastPointer.next != null) {
      previousPointer = slowPointer
      slowPointer = slowPointer.next!!
      fastPointer = fastPointer.next!!.next
    }

    // remove the link
    if (previousPointer != null) {
      previousPointer.next = null
    }

    return slowPointer
  }
}

class ListNode(val value: Int) {

  var next: ListNode? = null
}

class TreeNode(val value: Int) {

  var left: TreeNode? = null
  var right: TreeNode? = null

  override fun toString(): String {
    return "[$value] -> L: $left -> R: $right"
  }
}

fun main(args: Array<String>) {
  val solution = Solution()
  val node = ListNode(-10).apply {
    next = ListNode(-3).apply {
      next = ListNode(0).apply {
        next = ListNode(5).apply {
          next = ListNode(9)
        }
      }
    }
  }

  println(solution.sortedListToBST(node))
}
