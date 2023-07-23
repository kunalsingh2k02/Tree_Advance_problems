
class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BoundaryTraversal {

    public static void printLeftBoundary(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null) {
            System.out.print(root.data + " ");
            printLeftBoundary(root.left);
        } else if (root.right != null) {
            System.out.print(root.data + " ");
            printLeftBoundary(root.right);
        }
    }

    public static void printLeafNodes(TreeNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
            return;
        }

        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    public static void printRightBoundary(TreeNode root) {
        if (root == null)
            return;

        if (root.right != null) {
            printRightBoundary(root.right);
            System.out.print(root.data + " ");
        } else if (root.left != null) {
            printRightBoundary(root.left);
            System.out.print(root.data + " ");
        }
    }

    public static void boundaryTraversal(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        printLeftBoundary(root.left);

        printLeafNodes(root);

        printRightBoundary(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);

        System.out.println("Boundary Traversal of the Binary Tree:");
        boundaryTraversal(root);
    }
}

