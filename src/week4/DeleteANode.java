package week4;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class DeleteANode {

    class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    class SinglyLinkedList {
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
            }
            else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    class SinglyLinkedListPrintHelper {
        public static void printList(SinglyLinkedListNode node, String sep,
                                     BufferedWriter bufferedWriter) throws IOException {
            while (node != null) {
                bufferedWriter.write(String.valueOf(node.data));

                node = node.next;

                if (node != null) {
                    bufferedWriter.write(sep);
                }
            }
        }
    }

    class Result {

        /*
         * Complete the 'deleteNode' function below.
         *
         * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
         * The function accepts following parameters:
         *  1. INTEGER_SINGLY_LINKED_LIST llist
         *  2. INTEGER position
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

        public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
            // Write your code here
            if (position == 0) {
                SinglyLinkedListNode next = llist.next;
                llist = null;
                return next;
            }

            SinglyLinkedListNode temp = llist;
            SinglyLinkedListNode prev = null;
            int pos = 0;
            while (temp != null) {
                if (pos == position) break;
                prev = temp;
                temp = temp.next;
                pos++;
            }

            prev.next = temp.next;

            temp = null;
            return llist;
        }
    }
}


