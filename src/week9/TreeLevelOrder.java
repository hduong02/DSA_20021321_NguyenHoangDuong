package week9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeLevelOrder {

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

    public static void levelOrder(Node root) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        Node temp = null;
        while (!nodes.isEmpty())
        {
            temp = nodes.peek();
            nodes.remove();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                nodes.add(temp.left);
            }
            if (temp.right != null)
            {
                nodes.add(temp.right);
            }
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}
