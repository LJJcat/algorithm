package btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树-前序遍历
 */
public class PreOrder {


    public static void main(String[] args) {
        PreOrder preOrder = new PreOrder();
//        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode root = null;
        preOrder.preorderTraversal(root);
        preOrder.preorder2(root);
    }


    /**
     * 迭代算法
     *
     * @param root
     * @return
     */
    public List<Integer> preorder2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        if(root == null){
            return list;
        }

        LinkedList<TreeNode> stack = new LinkedList();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.getLast();
            list.add(treeNode.val);
            stack.removeLast();
            if (treeNode.right != null) {
                stack.add(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.add(treeNode.left);
            }

        }

        System.out.println(list);
        return list;
    }


    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        order(root, list);
        System.out.println(list);
        return list;
    }

    private void order(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            order(root.left, list);
        }
        if (root.right != null) {
            order(root.right, list);
        }
    }


}