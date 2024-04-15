package practice.knifemanager.mylist;

import java.util.NoSuchElementException;

public class MyLinkedListIterator implements MyIterator {

    private MyNode current;

    public MyLinkedListIterator(MyNode current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != null && current.getNext() != null;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object target = current.getPayload();
        current = current.getNext();
        return target;
    }

}

