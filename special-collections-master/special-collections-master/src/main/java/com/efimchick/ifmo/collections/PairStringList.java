package com.efimchick.ifmo.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class PairStringList implements List<String> {
    private final List<String> pairList = new ArrayList<>();

    @Override
    public int size() {
        return pairList.size();
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
    public Iterator<String> iterator() {
        return pairList.iterator();
    }

    @Override
    public Object[] toArray() {
        return pairList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return pairList.toArray(a);
    }

    @Override
    public boolean add(String s) {
        pairList.addAll(Arrays.asList(s, s));
        return true;
    }

    @Override
    public boolean remove(Object o) {
        pairList.remove(o);
        pairList.remove(o);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new NoSuchElementException();
    }

    @Override
    public boolean addAll(Collection<? extends String> collection) {
        for (String element : collection) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> collection) {
        for (String element : collection) {
            add(index, element);
            index = getNextIndex(index);
        }
        return true;
    }

    private int getNextIndex(int index) {
        index += 2;
        return index;
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
        pairList.clear();
    }

    @Override
    public String get(int index) {
        return pairList.get(index);
    }

    @Override
    public String set(int index, String element) {
        pairList.set(index, element);
        return pairList.set(getSecondIndex(index), element);
    }

    @Override
    public void add(int index, String element) {
        pairList.add(getIndexForAdd(index), element);
        pairList.add(getSecondIndex(getIndexForAdd(index)), element);
    }

    private int getIndexForAdd(int index) {
        if (!isEvenElement(index)) ++index;
        return index;
    }

    @Override
    public String remove(int index) {
        pairList.remove(index);
        return pairList.remove(getSecondIndex(index));
    }

    private int getSecondIndex(int index) {
        if (isEvenElement(index)) return index + 1;
        else return index - 1;
    }

    private boolean isEvenElement(int element) {
        return element % 2 == 0;
    }

    @Override
    public int indexOf(Object o) {
        throw new NoSuchElementException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new NoSuchElementException();
    }

    @Override
    public ListIterator<String> listIterator() {
        return pairList.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return pairList.listIterator(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new NoSuchElementException();
    }
}