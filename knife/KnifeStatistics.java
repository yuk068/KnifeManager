package practice.knifemanager.knife;

import practice.knifemanager.mylist.MyAbstractList;
import practice.knifemanager.mylist.MyArrayList;
import practice.knifemanager.mylist.MyList;

import java.util.Arrays;

public class KnifeStatistics {

    private MyList knives;
    private final KnifeManager manager;

    public KnifeStatistics(MyList knives, KnifeManager manager) {
        setKnives(knives);
        this.manager = manager;
    }

    public void setKnives(MyList knives) {
        boolean onlyKnives = Arrays.stream(knives.toArray()).allMatch(obj -> obj instanceof Knife);
        if (!onlyKnives) throw new IllegalArgumentException("This class only works with Knife");
        this.knives = knives;
    }

    private MyList categoryFilterHelper(String type, String subject) {
        Knife[] toFilter = Knife.convertToKnifeArray(knives.toArray());
        MyList filtered = new MyArrayList();
        if (type.equals("Manu")) {
            Arrays.stream(toFilter).filter(knife -> knife.getManufacturer().equals(subject))
                    .forEach(filtered::append);
        } else {
            Arrays.stream(toFilter).filter(knife -> knife.getAction().equals(subject))
                    .forEach(filtered::append);
        }
        return filtered;
    }

    private MyList numericalFilterHelper(String type, int howMany, boolean biggest) {
        MyAbstractList.checkBound(howMany, manager.getKnives().size() - 1);
        MyList toFilter;
        if (type.equals("Rating")) {
            toFilter = manager.sortRating(!biggest);
        } else {
            toFilter = manager.sortBladeLength(!biggest);
        }

        MyList filtered = new MyArrayList();
        for (int i = 0; i < howMany; i++) {
            filtered.append(toFilter.get(i));
        }

        return filtered;
    }

    private MyList boundFilterHelper(String type, boolean higher, double bound) {
        Knife[] toFilter = Knife.convertToKnifeArray(knives.toArray());
        MyList filtered = new MyArrayList();

        Arrays.stream(toFilter).filter(knife -> {
            double value = type.equals("Rating") ? knife.getRating() : knife.getBladeLength();
            return higher ? value > bound : value < bound;
        }).forEach(filtered::append);

        return filtered;
    }

    public MyList filterManufacturer(String manu) {
        return categoryFilterHelper("Manu", manu);
    }

    public MyList filterAction(String action) {
        return categoryFilterHelper("Action", action);
    }

    public MyList filterRating(int howMany, boolean highest) {
        return numericalFilterHelper("Rating", howMany, highest);
    }

    public MyList filterBladeLength(int howMany, boolean longest) {
        return numericalFilterHelper("BladeLength", howMany, longest);
    }

    public MyList filterBoundRating(double bound, boolean higher) {
        return boundFilterHelper("Rating", higher, bound);
    }

    public MyList filterBoundBladeLength(double bound, boolean higher) {
        return boundFilterHelper("BladeLength", higher, bound);
    }

}
