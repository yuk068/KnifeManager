package practice.knifemanager.mylist;

import java.util.NoSuchElementException;

public class MyArrayListIterator implements MyIterator {

    private final Object[] data;
    private int currentPosition;

    public MyArrayListIterator(Object[] data) {
        this.data = data;
        currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        int index = currentPosition;
        while (index < data.length && data[index] == null) {
            index++;
        }
        return index < data.length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (data[currentPosition] == null) {
            currentPosition++;
        }
        return data[currentPosition++];
    }

}
