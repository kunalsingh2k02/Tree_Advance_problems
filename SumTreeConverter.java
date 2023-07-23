
class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class SumTreeConverter {

    public static int convertToSumTree(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = convertToSumTree(root.left);
        int rightSum = convertToSumTree(root.right);

        int oldData = root.data;

        root.data = leftSum + rightSum;

        return root.data + oldData;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);

        System.out.println("Original Binary Tree (Inorder Traversal):");
        inorderTraversal(root);
        System.out.println();

        convertToSumTree(root);

        System.out.println("Sum Tree (Inorder Traversal):");
        inorderTraversal(root);
    }
}

