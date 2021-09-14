package btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树-最大深度
 */
public class MaxDepth104 {


    public static void main(String[] args) {
        MaxDepth104 maxDepth = new MaxDepth104();
        TreeNode root = new TreeNode(1, new TreeNode(10), new TreeNode(2, new TreeNode(3), new TreeNode(9, null, new TreeNode(4))));
        maxDepth.maxDepth(root);
    }


    /**
     * 广度优先算法
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }

            depth++;
        }

        return depth;
    }

    /**
     * 前序遍历  深度优先算法
     * <p>
     * 时间复杂度：O(n)，其中 nnn 为二叉树节点的个数。每个节点在递归中只被遍历一次。
     * <p>
     * 空间复杂度：O(height)，其中 height\textit{height}height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int maxDepth = Math.max(leftDepth, rightDepth) + 1;
        System.out.println(maxDepth);
        return maxDepth;
    }


}