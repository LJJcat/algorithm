package btree;

/**
 * 翻转二叉树
 */
public class FanZhuan226 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(10), new TreeNode(2, new TreeNode(3), new TreeNode(9, null, new TreeNode(4))));

    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;

    }
}