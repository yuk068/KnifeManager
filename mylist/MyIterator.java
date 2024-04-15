package practice.knifemanager.mylist;

import java.util.Iterator;

public interface MyIterator extends Iterator<Object> {

    @Override
    boolean hasNext();

    @Override
    Object next();

}
