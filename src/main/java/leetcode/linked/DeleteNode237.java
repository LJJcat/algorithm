package leetcode.linked;

/**
 * 删除节点
 */
public class DeleteNode237 {

    /**
     * 简直就是脑筋急转弯
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}