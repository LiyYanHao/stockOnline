package com.算法.数据结构与算法分析java.chapter_1.chapter_3.ch3_5;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author lyh on 2019/1/14
 */
public class MyLinkedListMain {

}

class MyLinkedList<T> implements Iterable<T> {
    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public MyLinkedList() {
        clear();
    }

    private int theSize;
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public void clear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, beginMarker, null);
        beginMarker.nextelement = endMarker;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, T x) {
        addBefore(getNode(idx), x);
    }

    public T get(int idx) {
        return getNode(idx).data;
    }

    public T set(int idx, T x) {
        Node<T> p = getNode(idx);
        T oldVal = p.data;
        return oldVal;
    }

    public T remove(int idx) {
        return remove(getNode(idx));
    }
    private Node<T> getNode(int idx){
        Node<T> p;
        if(idx<0||idx>size()){
            throw new IndexOutOfBoundsException();
        }
        if(idx<size()/2){
            p =beginMarker.nextelement;
            for (int i=0;i<idx;i++){
                p = p.nextelement;
            }
        }else {
            p = endMarker;
            for (int i=size();i>idx;i--){
                p = p.prevElement;
            }
        }
        return p;
    }
    private void addBefore(Node<T> p, T x) {
        Node<T> newNode = new Node<>(x, p.prevElement, p);
        newNode.prevElement.nextelement = newNode;
        p.prevElement = newNode;
        theSize++;
        modCount++;
    }

    public T remove(Node<T> node){
        node.nextelement.prevElement = node.nextelement;
        node.prevElement.nextelement = node.prevElement;
        theSize--;
        modCount++;
        return node.data;

    }
    private static class Node<T> {
        Node<T> prevElement;
        Node<T> nextelement;
        T data;

        public Node(T data, Node<T> nextelement, Node<T> prevElement) {
            this.nextelement = nextelement;
            this.prevElement = prevElement;
            this.data = data;
        }

        public Node<T> next(Node element) {
            return element.prevElement;
        }

    }

    private class LinkedListIterator implements Iterator<T>{
        private Node<T> current = beginMarker.nextelement;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        public boolean hasNext(){
            return current != endMarker;
        }

        public T next(){
            if(modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T nextItem = current.data;
            current = current.nextelement;
            okToRemove = true;
            return nextItem;

        }
        public void remove(){
            if(modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if(!okToRemove){
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prevElement);
            okToRemove = false;
            expectedModCount++;
        }
    }





}
