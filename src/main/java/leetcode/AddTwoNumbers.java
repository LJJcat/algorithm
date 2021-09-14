package leetcode;

public class AddTwoNumbers {

 public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4,new ListNode(3)));

        ListNode l2 = new ListNode(5, new ListNode(6,new ListNode(4)));

        addTwoNumbers.addTwoNumbers(l1, l2 );
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry = 0;
        while(l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val: 0;
            int n2 = l2 != null ? l2.val: 0;
            int sum = n1 + n2 + carry;
            if(curr == null){
                curr = new ListNode(sum % 10);
            } else{
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
            }

            carry = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry == 1){
            curr.next = new ListNode(carry);
        }

        return result.next;

    }
}