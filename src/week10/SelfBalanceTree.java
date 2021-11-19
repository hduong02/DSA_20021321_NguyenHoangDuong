package week10;

public class SelfBalanceTree {

    static class Node {
        Node left;
        Node right;
        int val;
        int ht;

        Node() {}

        Node(int val, int ht) {
            this.ht = ht;
            this.val = val;
            left = null;
            right = null;
        }
    }

    static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node();
            root.val = val;
            root.ht = getHeight(root);
            return root;
        }

        if (val > root.val) {
            root.right = insert(root.right, val);
        }
        else if (val < root.val) {
            root.left = insert(root.left, val);
        }

        int bf = getHeight(root.left) - getHeight(root.right);

        if (bf > 1) {
            int childBf = getHeight(root.left.left) - getHeight(root.left.right);
            if (childBf > 0) {
                root = RightRotate(root);
            }
            else if (childBf < 0) {
                root.left = LeftRotate(root.left);
                root = RightRotate(root);
            }
        }
        else if (bf < -1) {
            int childBf = getHeight(root.right.left) - getHeight(root.right.right);
            if (childBf > 0) {
                root.right = RightRotate(root.right);
                root = LeftRotate(root);
            }
            else if (childBf < 0) {
                root = LeftRotate(root);
            }
        }
        else {
            root.ht = getHeight(root);
        }

        return root;
    }

    static Node RightRotate(Node root) {
        Node newNode = root.left;
        Node temp = newNode.right;
        newNode.right = root;
        root.left = temp;
        root.ht = getHeight(root);
        newNode.ht = getHeight(newNode);
        return newNode;
    }

    static Node LeftRotate(Node root) {
        Node newNode = root.right;
        Node temp = newNode.left;
        newNode.left = root;
        root.right = temp;
        root.ht = getHeight(root);
        newNode.ht = getHeight(newNode);
        return newNode;
    }

    static int getHeight(Node node) {
        if(node == null) {
            return -1;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
