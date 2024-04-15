package practice.knifemanager.mylist;

public class MyLinkedList extends MyAbstractList {

    private MyNode head;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public void append(Object thing) {
        if (size == 0) {
            head = new MyNode(thing);
        } else {
            getNodeByIndex(size - 1).setNext(new MyNode(thing));
        }
        size++;
    }

    @Override
    public void insert(Object thing, int index) {
        checkBound(index, size);
        MyNode newNode = new MyNode(thing);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            MyNode prevNode = getNodeByIndex(index - 1);
            newNode.setNext(prevNode.getNext());
            prevNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public void set(Object thing, int index) {
        checkBound(index, size - 1);
        getNodeByIndex(index).setPayload(thing);
    }

    @Override
    public void delete(int index) {
        checkBound(index, size - 1);
        if (index == 0) {
            head = head.getNext();
        } else {
            MyNode prevNode = getNodeByIndex(index - 1);
            MyNode targetNode = prevNode.getNext();
            prevNode.setNext(targetNode.getNext());
        }
        size--;
    }

    @Override
    public void delete(Object thing) {
        for (int i = 0; i < size; i++) {
            if (getNodeByIndex(i).getPayload().equals(thing)) {
                delete(i);
                i--;
            }
        }
    }

    @Override
    public Object get(int index) {
        checkBound(index, size - 1);
        return getNodeByIndex(index).getPayload();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = getNodeByIndex(i).getPayload();
        }
        return array;
    }

    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator(head);
    }

    private MyNode getNodeByIndex(int index) {
        MyNode target = head;
        for (int i = 0; i < index; i++) {
            target = target.getNext();
        }
        return target;
    }

}
