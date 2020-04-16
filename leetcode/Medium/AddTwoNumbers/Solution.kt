class Solution {

  fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    return calculate(l1, l2)
  }

  // O(N)
  fun calculate(l1: ListNode?, l2: ListNode?): ListNode? {
    var n1: ListNode? = l1
    var n2: ListNode? = l2
    val header = ListNode(0)
    var pointer = header 
    var carry = 0
    while (n1 != null || n2 != null) {
      val value1 = n1?.`val` ?: 0
      val value2 = n2?.`val` ?: 0
      val sum = value1 + value2 + carry
      pointer.next = ListNode(sum % 10)
      pointer = pointer.next!!
      carry = sum / 10
      n1 = n1?.next
      n2 = n2?.next
    }

    if (carry > 0) { 
      pointer.next = ListNode(carry)
    }

    return header.next
  }
}

class ListNode(var `val`: Int) {

  var next: ListNode? = null

  override fun toString(): String {
    return "${`val`} -> ${next.toString()}"
  }
}

fun main(args: Array<String>) {
  println(Solution().addTwoNumbers(
    ListNode(2).apply { next = ListNode(4).apply { next = ListNode(3) } },
    ListNode(5).apply { next = ListNode(6).apply { next = ListNode(4) } }
  ).toString())
  println(Solution().addTwoNumbers(
    ListNode(5),
    ListNode(5)
  ).toString())
  println(Solution().addTwoNumbers(
    ListNode(1),
    ListNode(9).apply { next = ListNode(9) }
  ).toString())

}
