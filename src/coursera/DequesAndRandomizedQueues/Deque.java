package coursera.DequesAndRandomizedQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return this.size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        Node newNode = new Node();
        newNode.item = item;
        if (size == 0) {
            first = newNode;
            last = newNode;
        }
        else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
            newNode.prev = null;
        }
        this.size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        Node newNode = new Node();
        newNode.item = item;

        if (size == 0) {
            first = newNode;
            last = newNode;
        }
        else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
            newNode.next = null;
        }
        this.size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        Item item = first.item;
        this.size--;
        if (isEmpty()) {
            last = null;
            first = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        Item item = last.item;
        this.size--;
        if (isEmpty()) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ItemIterator();
    }

    private class ItemIterator implements Iterator<Item> {
        private Node node = first;

        @Override
        public boolean hasNext() {
            return (node != null);
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more Objects in the deque");
            }
            Item returnItem = node.item;
            node = node.next;
            return returnItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        System.out.println(deque.size());
        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");
        deque.addFirst("4");
        deque.addLast("5");
        System.out.println(deque.size());
        for (String s : deque) {
            System.out.println(s);
        }
    }
}
