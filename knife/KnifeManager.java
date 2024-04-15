package practice.knifemanager.knife;

import practice.knifemanager.mylist.MyArrayList;
import practice.knifemanager.mylist.MyList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class KnifeManager {

    private MyList knives;

    public KnifeManager(MyList knives) {
        setKnives(knives);
    }

    public void setKnives(MyList knives) {
        boolean onlyKnives = Arrays.stream(knives.toArray()).allMatch(obj -> obj instanceof Knife);
        if (!onlyKnives) throw new IllegalArgumentException("This class only works with Knife");
        this.knives = knives;
    }

    public MyList getKnives() {
        return knives;
    }

    private MyList sortHelper(boolean ascending, Comparator<Knife> byWhat) {
        Knife[] toSort = Knife.convertToKnifeArray(knives.toArray());
        if (ascending) Arrays.sort(toSort, byWhat);
        else Arrays.sort(toSort, Collections.reverseOrder(byWhat));
        MyList sorted = new MyArrayList();
        Arrays.stream(toSort).forEach(sorted::append);
        return sorted;
    }

    public MyList sortName(boolean ascending) {
        return sortHelper(ascending, KnifeComparator.compareName());
    }

    public MyList sortManufacturer(boolean ascending) {
        return sortHelper(ascending, KnifeComparator.compareManufacturer());
    }

    public MyList sortBladeLength(boolean ascending) {
        return sortHelper(ascending, KnifeComparator.compareBladeLength());
    }

    public MyList sortRating(boolean ascending) {
        return sortHelper(ascending, KnifeComparator.compareRating());
    }
    
}
