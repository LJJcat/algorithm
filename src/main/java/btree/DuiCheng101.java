package btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 【堆成二叉树】
 */
public class DuiCheng101 {


    /**
     * 迭代算法
     * 队列中添加 对称的两个节点，判断是否一致
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(left);
        queue.offer(right);

        while (!queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);

        }
        return true;
    }


    /**
     * 【递归】
     * 比较左右两棵树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        return check(p.left, q.right) && check(p.right, q.left);
    }


}