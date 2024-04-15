package practice.knifemanager.knife;

import java.util.Comparator;

public interface KnifeComparator extends Comparator<Knife> {

    static Comparator<Knife> compareName() {
        return Comparator.comparing(Knife::getName);
    }

    static Comparator<Knife> compareManufacturer() {
        return Comparator.comparing(Knife::getManufacturer);
    }

    static Comparator<Knife> compareBladeLength() {
        return Comparator.comparingDouble(Knife::getBladeLength);
    }

    static Comparator<Knife> compareRating() {
        return Comparator.comparingDouble(Knife::getRating);
    }

}
