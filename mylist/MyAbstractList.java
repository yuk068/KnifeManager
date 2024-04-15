package practice.knifemanager.mylist;

public abstract class MyAbstractList implements MyList {

    public MyAbstractList() {

    }

    public static void checkBound(int index, int limit) {
        if (index < 0 || index > limit) throw new IndexOutOfBoundsException();
    }

    public void printList() {
        this.forEach(System.out::println);
    }

    @Override
    public String toString() {
        StringBuilder listString = new StringBuilder("[");

        for (int i = 0; i < this.size(); i++) {
            if (i == this.size() - 1) {
                listString.append(this.get(i).toString());
            } else {
                listString.append(this.get(i).toString()).append(", ");
            }
        }
        listString.append("]");
        return listString.toString();
    }

}
