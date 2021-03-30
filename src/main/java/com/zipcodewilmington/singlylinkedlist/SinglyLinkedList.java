package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>>  {

    private Node head;
    private Node tail;
    private Integer size;

    public SinglyLinkedList() {

        this.size = 0;
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T d) {
            data = d;
            next = null;
        }
    }

    public void add(T data) {
        Node newNode = new Node(data);

        // empty list then make newNode the head & the tail
        if (head == null) {
            head = newNode;
            tail = newNode;
        // not empty list then add newNode to the end
        } else {
            tail.next = newNode;    // the tail has to point to newNode (since it's not the tail anymore!)
            tail = newNode;         // newNode is added to the end - so it's now the tail!
        }

        this.size++;
    }

    public void remove(int index) {
        Node temp = head;
        Node newNext;

        // deleting the head
        if (index == 0) {
            head = head.next;       // head is now next item in the list
            return;
        }

        // deleting any other node
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;               // temp now is the item before the one to be deleted
            newNext = temp.next.next;       // get new next item after deletion
            temp.next = newNext;            // link temp to the item after the one to be deleted
        }

        this.size--;
    }

    public Boolean contains(T elementToFind) {

        Node current = head;
        Integer index = 0;
        while (current != null) {
            if (current.data.equals(elementToFind)) {
                return true;
            }
            current = current.next;
            index++;
        }
        return false;
    }

    public Integer find(T elementToFind) {

        Node current = head;
        Integer index = 0;
        while (current != null) {
            if (current.data.equals(elementToFind)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public Integer size(){

        return this.size;
    }

    public T get(int index) {
        Node current = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> copyOfList = new SinglyLinkedList<T>();

        Node curr = head;
        for (int i = 0; i <= this.size; i++) {
            copyOfList.add(curr.data);
            curr = head.next;
        }

        return copyOfList;
    }

    public void sort() {
        T temp = null;
        for (int i = 0; i <= this.size; i++) {
            Node prev = head;
            Node curr = head.next;
            while (curr != null) {
                if (prev.data.compareTo(curr.data) > 0) {
                    temp = prev.data;
                    prev.data = curr.data;
                    curr.data = temp;
                }
                prev = prev.next;
                curr = curr.next;
            }
        }
    }
}
