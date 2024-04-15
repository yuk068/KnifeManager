package practice.knifemanager.mylist;

import java.util.Arrays;

public class MyArrayList extends MyAbstractList {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public MyIterator iterator() {
        return new MyArrayListIterator(data);
    }

    @Override
    public void append(Object thing) {
        if (size >= data.length) enlarge();
        data[size++] = thing;
    }

    @Override
    public void insert(Object thing, int index) {
        checkBound(index, size);
        if (size >= data.length) enlarge();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = thing;
        size++;
    }

    @Override
    public void set(Object thing, int index) {
        checkBound(index, size - 1);
        data[index] = thing;
    }

    @Override
    public void delete(int index) {
        checkBound(index, size - 1);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    @Override
    public void delete(Object thing) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(thing)) {
                delete(i);
                i--;
            }
        }
    }

    @Override
    public Object get(int index) {
        checkBound(index, size - 1);
        return data[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    private void enlarge() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

}
