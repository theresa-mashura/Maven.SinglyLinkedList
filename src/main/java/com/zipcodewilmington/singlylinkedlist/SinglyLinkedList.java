package com.zipcodewilmington.singlylinkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {

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
        return this.size();
    }

    public void get(int index) {

    }

    public void copy(){

    }

    public void sort(){

    }

}
