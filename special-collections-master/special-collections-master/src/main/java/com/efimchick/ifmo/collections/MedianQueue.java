package com.efimchick.ifmo.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class MedianQueue implements Queue<Integer> {
    private final LinkedList<Integer> medianQueue = new LinkedList<>();

    @Override
    public int size() {
        return medianQueue.size();
    }

    @Override
    public boolean isEmpty() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean contains(Object o) {
        throw new NoSuchElementException();
    }

    @Override
    public Iterator<Integer> iterator() {
        throw new NoSuchElementException();
    }

    @Override
    public Object[] toArray() {
        throw new NoSuchElementException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new NoSuchElementException();
    }

    @Override
    public boolean add(Integer integer) {
        throw new NoSuchElementException();
    }

    @Override
    public boolean remove(Object o) {
        throw new NoSuchElementException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new NoSuchElementException();
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        throw new NoSuchElementException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new NoSuchElementException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new NoSuchElementException();
    }

    @Override
    public void clear() {
        medianQueue.clear();
    }

    @Override
    public boolean equals(Object o) {
        throw new NoSuchElementException();
    }

    @Override
    public int hashCode() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean offer(Integer integer) {
        medianQueue.offer(integer);
        rearrangeElements();
        return true;
    }

    @Override
    public Integer remove() {
        throw new NoSuchElementException();
    }

    @Override
    public Integer poll() {
        return medianQueue.poll();
    }

    @Override
    public Integer element() {
        throw new NoSuchElementException();
    }

    @Override
    public Integer peek() {
        return medianQueue.peek();
    }

    private void rearrangeElements() {
        LinkedList<Integer> tempList = new LinkedList<>(medianQueue);
        Collections.sort(tempList);
        clear();
        int initialSize = tempList.size();
        for (int i = 0; i < initialSize; i++) {
            if (isEven(i)) {
                medianQueue.addFirst(tempList.pollLast());
            } else {
                medianQueue.addFirst(tempList.pollFirst());
            }
        }
    }

    private boolean isEven(int value) {
        return value % 2 == 0;
    }
}