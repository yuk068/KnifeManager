package practice.knifemanager.knife;

public interface KnifeComparable extends Comparable<Knife> {

    @Override
    int compareTo(Knife another); // Comparable compares rating

}
