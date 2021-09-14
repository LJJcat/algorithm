package btree;

import java.util.ArrayList;
import java.util.List;

/**
 * 【二叉树展开为链表】
 */
public class ZhanKaiLianBiao114 {

    public static void main(String[] args) {
        ZhanKaiLianBiao114 zhanKaiLianBiao114 = new ZhanKaiLianBiao114();
        /**
         *         1
         *    10      2
         *           3  9
         */
        TreeNode root = new TreeNode(1, new TreeNode(10), new TreeNode(2, new TreeNode(3), new TreeNode(9)));
        zhanKaiLianBiao114.flatten(root);
    }

    public void flatten(TreeNode root) {

        List<TreeNode> list = new ArrayList<TreeNode>();
        // 前序遍历
        preOrder(root, list);
        System.out.println(list);

        for (int i = 1; i < list.size(); i++) {

            TreeNode result = list.get(i - 1);
            TreeNode curr = list.get(i);
            result.left = null;
            result.right = curr;
        }

        System.out.println(root);
    }

    private void preOrder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

}