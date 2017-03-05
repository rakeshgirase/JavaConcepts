package com.exuberant.tutorials.javaconcept.practice.selfqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> implements BlockingQueue<E> {
    private List<E> q = new ArrayList<>();
    private Lock lock = new ReentrantLock();
    private int upperLimit = Integer.MAX_VALUE;

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        lock.lock();
        if (q.size() > 0) {
            E e = q.remove(0);
            lock.unlock();
            return e;
        }
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int size() {
        return q.size();
    }

    @Override
    public boolean isEmpty() {
        return q.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return q.iterator();
    }

    @Override
    public Object[] toArray() {
        return q.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return q.toArray(a);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return q.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return q.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return q.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return q.retainAll(c);
    }

    @Override
    public void clear() {
        q.clear();
    }

    @Override
    public boolean add(E e) {
        lock.lock();
        boolean b = q.add(e);
        lock.unlock();
        return b;
    }

    @Override
    public boolean offer(E e) {
        return ((q.size() + 1) > upperLimit);
    }

    @Override
    public void put(E e) throws InterruptedException {
        this.add(e);
    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit)
            throws InterruptedException {
        return false;
    }

    @Override
    public E take() throws InterruptedException {
        return this.poll();
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }


}
