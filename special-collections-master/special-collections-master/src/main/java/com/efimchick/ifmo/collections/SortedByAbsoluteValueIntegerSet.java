package com.efimchick.ifmo.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Comparator;

class SortedByAbsoluteValueIntegerSet implements Set<Integer> {
    private final Set<Integer> sortedIntegers = new TreeSet<>(new IntegerComparator());

    @Override
    public int size() {
        return sortedIntegers.size();
    }

    @Override
    public boolean isEmpty() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean contains(Object o) {
        return sortedIntegers.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return sortedIntegers.iterator();
    }

    @Override
    public Object[] toArray() {
        return sortedIntegers.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return sortedIntegers.toArray(a);
    }

    @Override
    public boolean add(Integer integer) {
        return sortedIntegers.add(integer);
    }

    @Override
    public boolean remove(Object o) {
        return sortedIntegers.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new NoSuchElementException();
    }

    @Override
    public boolean addAll(Collection<? extends Integer> collection) {
        collection.forEach(this::add);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new NoSuchElementException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new NoSuchElementException();
    }

    @Override
    public void clear() {
        throw new NoSuchElementException();
    }

    private static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Math.abs(o1) - Math.abs(o2);
        }
    }
}