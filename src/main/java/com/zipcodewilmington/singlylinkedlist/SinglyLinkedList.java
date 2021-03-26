package com.zipcodewilmington.singlylinkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    public Node head;
    public Node tail;

    public void add(int data) {
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
    }

    public void remove(int index) {
        Node current = head;
        Node newNext;

        // deleting the head
        if (index == 0) {
            head = head.next;       // head is now next item in the list
            return;
        }

        // deleting any other node
        for (int i = 0; i < index - 1; i++) {
            current = current.next;         // temp now is the item before the one to be deleted
            newNext = current.next.next;    // get new next item after deletion
            current.next = newNext;         // link temp to the item after the one to be deleted
        }
    }

    public void contains() {

    }

    public void find() {

    }

    public void size(){

    }

    public void get() {

    }

    public void copy(){

    }

    public void sort(){

    }

}
