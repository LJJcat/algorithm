package btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树-层序遍历
 */
public class LevelOrder {


    public static void main(String[] args) {
        LevelOrder preOrder = new LevelOrder();
        /**
         *         1
         *    10      2
         *           3  9
         */
        TreeNode root = new TreeNode(1, new TreeNode(10), new TreeNode(2, new TreeNode(3), new TreeNode(9)));
//        TreeNode root = null;
        preOrder.levelOrder2(root);
        preOrder.levelOrder(root);
    }


    /**
     * 队列
     * BFS（Breath First Search）广度优先搜索
     * queue.offer(root); 末尾追加元素
     * queue.peek(); 队首出队
     * queue.poll(); 获取队首元素
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<Integer>();
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode currNode = queue.poll();
                subList.add(currNode.val);
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(subList);
        }
        System.out.println(result);
        return result;
    }


    /**
     * DFS（Deep First Search）深度优先搜索
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        order(root, result, 0);
        System.out.println(result);
        return result;
    }

    private void order(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);
        order(root.left, list, level + 1);
        order(root.right, list, level + 1);
    }


}