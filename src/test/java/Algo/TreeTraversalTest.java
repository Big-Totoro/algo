package Algo;

import Algo.Misc.TreeTraversal;
import org.junit.Test;

public class TreeTraversalTest {

    private TreeTraversal.TreeNode root = new TreeTraversal.TreeNode(
            3,
            new TreeTraversal.TreeNode(0,
                    null,
                    new TreeTraversal.TreeNode(2,
                            new TreeTraversal.TreeNode(1),
                            null
                    )
            ),
            new TreeTraversal.TreeNode(4)
    );

    @Test
    public void testPreorder() {
        System.out.println("testPreorder");
        TreeTraversal traversal = new TreeTraversal();
        traversal.preorder_traversal(root);
    }

    @Test
    public void testInorder() {
        System.out.println("testInorder");
        TreeTraversal traversal = new TreeTraversal();
        traversal.inorder_traversal(root);
    }

    @Test
    public void testPostorder() {
        System.out.println("testPostorder");
        TreeTraversal traversal = new TreeTraversal();
        traversal.postorder_traversal(root);
    }
}
