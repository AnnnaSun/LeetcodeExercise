package src.EverydayTest;


import java.util.HashSet;
import java.util.Set;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class solution10_12 {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int num : nums) {
            numsSet.add(num);
        }
        boolean inSet = false;
        int res = 0;
        while (head != null) {
            if (numsSet.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    res++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return res;

    }
}
