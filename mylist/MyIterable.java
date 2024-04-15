package practice.knifemanager.mylist;

public interface MyIterable extends Iterable<Object> {

    @Override
    MyIterator iterator();

}
