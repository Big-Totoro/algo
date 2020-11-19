package Algo.Misc;

import java.util.Objects;

public class TreeTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }
    
    public void preorder_traversal(TreeNode root) {
        if (root != null) {
            System.out.printf("Tree node: %d\r\n", root.val);
            preorder_traversal(root.left);
            preorder_traversal(root.right);
        }
    }

    public void inorder_traversal(TreeNode root) {
        if (root != null) {
            inorder_traversal(root.left);
            System.out.printf("Tree node: %d\r\n", root.val);
            inorder_traversal(root.right);
        }
    }

    public void postorder_traversal(TreeNode root) {
        if (root != null) {
            postorder_traversal(root.left);
            postorder_traversal(root.right);
            System.out.printf("Tree node: %d\r\n", root.val);
        }
    }
}
