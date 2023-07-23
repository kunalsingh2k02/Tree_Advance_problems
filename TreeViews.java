import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class TreeViews {

    public static void printTopView(TreeNode root) {
        if (root == null)
            return;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> hdQueue = new LinkedList<>();

        queue.add(root);
        hdQueue.add(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int hd = hdQueue.poll();

            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if (node.left != null) {
                queue.add(node.left);
                hdQueue.add(hd - 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                hdQueue.add(hd + 1);
            }
        }

        for (int value : map.values()) {
            System.out.print(value + " ");
        }
    }

    public static void printBottomView(TreeNode root) {
        if (root == null)
            return;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> hdQueue = new LinkedList<>();

        queue.add(root);
        hdQueue.add(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int hd = hdQueue.poll();

            map.put(hd, node.data);

            if (node.left != null) {
                queue.add(node.left);
                hdQueue.add(hd - 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                hdQueue.add(hd + 1);
            }
        }

        for (int value : map.values()) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        System.out.print("Top View: ");
        printTopView(root);

        System.out.println();

        System.out.print("Bottom View: ");
        printBottomView(root);
    }
}

