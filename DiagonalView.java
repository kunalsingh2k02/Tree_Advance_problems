import java.util.*;
class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class DiagonalView {

    public static void printDiagonalView(TreeNode root) {
        if (root == null)
            return;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> diagonalLevelQueue = new LinkedList<>();

        queue.add(root);
        diagonalLevelQueue.add(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int diagonalLevel = diagonalLevelQueue.poll();
            ArrayList<Integer> diagonalList = map.getOrDefault(diagonalLevel, new ArrayList<>());
            diagonalList.add(node.data);
            map.put(diagonalLevel, diagonalList);

            if (node.left != null) {
                queue.add(node.left);
                diagonalLevelQueue.add(diagonalLevel + 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                diagonalLevelQueue.add(diagonalLevel);
            }
        }

        for (ArrayList<Integer> diagonalList : map.values()) {
            for (int value : diagonalList) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        System.out.println("Diagonal View of the Binary Tree:");
        printDiagonalView(root);
    }
}

