package algorithm.searching;

public class AddList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        while (l1.next != null || l2.next != null) {
            if (l1.next != null && l2.next != null) {
                if (res.val + l1.val + l2.val <= 9) {
                    res.val = res.val + l1.val + l2.val;
                    l1 = l1.next;
                    l2 = l2.next;
                } else {
                    res.val = (res.val + l1.val + l2.val) % 10;
                    res.next.val = 1;
                    l1 = l1.next;
                    l2 = l2.next;
                }
            } else if (l1.next != null) {
                res.val = l1.val;
                l1 = l1.next;
            } else if (l2.next != null) {
                res.val = l2.val;
                l2 = l2.next;
            }
            res = res.next;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
