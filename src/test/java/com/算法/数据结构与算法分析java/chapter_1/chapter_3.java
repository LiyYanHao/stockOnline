package com.算法.数据结构与算法分析java.chapter_1;

import org.apache.commons.collections.iterators.ArrayListIterator;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.hamcrest.internal.ArrayIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * 3.4
 */

class MyArrayList<T> implements Iterator<T> {
    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    T[] list;
    public int length = list.length;

    public MyArrayList() {
        list = (T[]) new Object[10];
    }

    public MyArrayList(T[] list) {
        this.list = list;
        length = list.length;
    }

    public T get(int index) {
        if (list == null) {
            throw new OutOfRangeException(0, 0, index);
        }
        return list[index];
    }

    public void set(T element) {
        if (list == null) {
            list = (T[]) new Object[10];
            if (list.length == length) {
                list = (T[]) new Object[length + 10];
            }

            list[length] = element;
        }
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void clear() {
        list = (T[]) new Object[10];
    }

    public void remove(T element) {
        for (int i = 0; i < length; i++) {
            if (list[i].equals(element)) {
                for (int j = i; j < length; j++) {
                    list[j] = list[j + 1];
                    if (j == length) {
                        list[j] = null;
                    }
                }
            }
        }
    }


}


class MyArrayList2<T> implements Iterator<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T[] theItems;

    public MyArrayList2() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    public T set(int idx, T newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, T x) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
            for (int i = theSize; i < idx; i--) {
                theItems[i] = theItems[i - 1];
            }
            theItems[idx] = x;
            theSize++;
        }
    }

    public T remove(int idx) {
        T removedItem = theItems[idx];
        if (idx < 0 || idx > size() - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removedItem;
    }

    public Iterator<T> Iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current<size();
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList2.this.remove(--current);
        }

    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}












