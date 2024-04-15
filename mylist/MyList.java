package practice.knifemanager.mylist;

public interface MyList extends MyIterable {

    void append(Object thing);

    void insert(Object thing, int index);

    void set(Object thing, int index);

    void delete(int index);

    void delete(Object thing);

    Object get(int index);

    int size();

    Object[] toArray();

    void printList();

}
