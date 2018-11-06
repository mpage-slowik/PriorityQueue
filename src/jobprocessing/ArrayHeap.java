package jobprocessing;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 * @param <E>
 */
public class ArrayHeap<E extends Comparable<E>> extends PriorityQueue {

    private E arr[];
    private int size;

    private E head;
    private E tail;

    public ArrayHeap() {
        arr = (E[]) new Comparable[10];
        size = 0;
    }

    @Override
    public boolean add(Object e) {
        if (size == 0) {
            head = (E) e;
            tail = (E) e;
            arr[size] = (E) e;
            size++;
            return true;
        } else {
            resize();
            tail = (E) e;
            arr[size] = (E) e;
            size++;
            upheap();
            head = arr[0];
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0) {
            return false;
        }
        int index = containsIndex(o);
        if (index == -1) {
            return false;
        } else {
            arr[index] = null;
            arr[index] = tail;

            size--;
            tail = arr[size - 1];
            downheap();
            head = arr[0];
        }
        return true;
    }

    @Override
    public Object poll() {
        return remove(head);
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

    private void upheap() {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].compareTo(arr[i / 2]) < 0) {
                E temp = arr[i / 2];
                arr[i / 2] = arr[i];
                arr[i] = temp;
            }
        }
    }

    private void downheap() {

        for (int i = 0; i < size; i++) {
            if (arr[2 * i + 1] != null) {
                if (arr[i].compareTo(arr[2 * i + 1]) > 0) {
                    E temp = arr[2 * i + 1];
                    arr[2 * i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
            if (arr[2 * i + 2] != null) {
                if (arr[i].compareTo(arr[2 * i + 2]) > 0) {
                    E temp = arr[2 * i + 2];
                    arr[2 * i + 2] = arr[i];
                    arr[i] = temp;
                }
            }
        }
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

    @Override
    public Comparator comparator() {
        return super.comparator(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        size = 0;
        arr = (E[]) new Comparable[10];
    }

    @Override
    public int size() {
        return size;
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

    private int containsIndex(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object peek() {
        return super.peek(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        return super.iterator(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(Object[] a) {
        return super.toArray(a); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        return super.toArray(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean offer(Object e) {
        return super.offer(e); //To change body of generated methods, choose Tools | Templates.
    }

}
