package week10;

public class BST_Check {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    boolean checkBST(Node node, int min, int max) {
        if (node == null)
            return true;
        return  min < node.data && node.data < max
                && checkBST(node.left, min, node.data)
                && checkBST(node.right, node.data, max);
    }
    boolean checkBST(Node root) {
        return checkBST(root, 0, 10000);
    }
}
