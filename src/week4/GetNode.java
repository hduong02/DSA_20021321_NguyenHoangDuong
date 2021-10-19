package week4;

import java.io.*;
import java.util.*;

import static week4.GetNode.Result.getNode;


public class GetNode {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    class Result {

        /*
         * Complete the 'getNode' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_SINGLY_LINKED_LIST llist
         *  2. INTEGER positionFromTail
         */

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */

        public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
            // Write your code here
            if (llist == null) return -1;

            int count1 = 0, count2 = 0;
            SinglyLinkedListNode temp = llist;
            SinglyLinkedListNode node = llist;

            while (temp.next != null) {
                count2++;
                temp = temp.next;
                if (count2 - positionFromTail > count1) {
                    node = node.next;
                    count1++;
                }
            }
            return node.data;
        }

    }
}
