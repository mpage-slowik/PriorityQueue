package jobprocessing;

import java.util.PriorityQueue;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 * @param <E>
 */
public class UnsortedList<E extends Comparable<E>> extends PriorityQueue {

    private E arr[];
    private int size;

    public UnsortedList() {
        arr = (E[]) new Comparable[10];
        size = 0;
    }

    @Override
    public int size() {
        return size - 1;
    }

    @Override
    public boolean add(Object e) {
        boolean added = false;
        if (arr != null) {
            resize();
            arr[size] = (E) e;
            size++;
            added = true;
        }
        return added;
    }

    @Override
    public Object remove() {//when i remove, find smallest and remove and return smallest prioriy
        if (isEmpty()) {
            return new IndexOutOfBoundsException("");
        } else {

            int smallestIndex = 0;

            for (int i = 1; i < size; i++) {
                if (arr[i].compareTo(arr[smallestIndex]) < 1) {
                    smallestIndex = i;
                }
            }
            E element = arr[smallestIndex];
            arr[smallestIndex] = null;
            shift();
            size--;
            return element;
        }
    }

    @Override
    public Object poll() {
        if (isEmpty()) {
            return null;
        } else {
            return remove();
        }
    }

    @Override
    public boolean offer(Object e) {
        return add(e);
    }

    @Override
    public boolean remove(Object o) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (arr[i].equals(o)) {
                    arr[i] = null;
                    shift();
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        arr = (E[]) new Comparable[10];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(",")).append("]");
        return sb.toString();
    }

    private void resize() {
        if (size >= arr.length - 2) {
            E arr2[] = (E[]) new Comparable[(arr.length * 2)];
            moveArray(arr2);
        } else if (Math.floor(arr.length / 4) > size) {
            E arr2[] = (E[]) new Comparable[(arr.length / 2)];
            moveArray(arr2);
        }
    }

    private void moveArray(E[] arr2) {
        for (int i = 0; i < size; i++) {
            arr2[i] = arr[i];
        }
        arr = arr2;
    }

    private void shift() {
        E arr2[] = (E[]) new Comparable[size];
        int j = 0;
        for (int i = 0; i < size; i++) {

            if (arr[i] != null) {
                arr2[j] = arr[i];
                j++;
            }
        }
        arr = arr2;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(Object[] a
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object element() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(" Size: " + size);
        } else {
            return arr[0];
        }
    }
}
