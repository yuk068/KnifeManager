package practice.knifemanager.knife;

import practice.knifemanager.mylist.MyArrayList;
import practice.knifemanager.mylist.MyList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

public class TestAppBladeHQ {

    private static final MyList knives = new MyArrayList();
    private static final KnifeManager knifeManager = new KnifeManager(knives);
    private static final KnifeStatistics knifeStats = new KnifeStatistics(knives, knifeManager);
    private static final int HOW_MANY = 5; // Default howMany
    private static final double BLADE_LENGTH_BOUND = 8.50; // Default blade length bound
    private static final double RATING_BOUND = 4.2; // Default rating bound

    public static void main(String[] args) {
        System.out.println("Welcome to bladehq.com");
        init();
//        testSortByName(true);
//        testSortByManufacturer(true);
//        testSortByBladeLength(true);
//        testSortRating(true);

//        testFilterManufacturer("BRS");
//        testFilterAction("Bushings");
//        testFilterBladeLength(false);
//        testFilterRating(true);

//        testFilterRatingBound(true);
//        testFilterBladeLengthBound(false);
    }

    public static void init() {
        String filePath = "C:\\Users\\Phong Vu\\IdeaProjects\\2024\\src\\practice\\knifemanager\\knife\\bladeHQ_data.csv";
        readData(filePath);
    }

    public static void readData(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> dataList = parseLineToStringList(line);
                if (dataList.get(0).equals("Type")) continue;
                String packageName = Knife.class.getPackageName();
                String className = packageName + "." + dataList.get(0);
                Class<?> knifeClass = Class.forName(className);
                Constructor<?> constructor = knifeClass.getConstructor(String.class, String.class, String.class,
                        double.class, double.class);
                knives.append(constructor.newInstance(dataList.get(3), dataList.get(1), dataList.get(2),
                        Double.parseDouble(dataList.get(4)), Double.parseDouble(dataList.get(5))));
            }
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> parseLineToStringList(String line) {
        return Arrays.stream(line.trim().split(",")).toList();
    }

    public static void testSortByName(boolean ascending) {
        MyList sorted = knifeManager.sortName(ascending);
        sorted.printList();
    }

    public static void testSortByManufacturer(boolean ascending) {
        MyList sorted = knifeManager.sortManufacturer(ascending);
        sorted.printList();
    }

    public static void testSortByBladeLength(boolean ascending) {
        MyList sorted = knifeManager.sortBladeLength(ascending);
        sorted.printList();
    }

    public static void testSortRating(boolean ascending) {
        MyList sorted = knifeManager.sortRating(ascending);
        sorted.printList();
    }

    public static void testFilterManufacturer(String manu) {
        MyList filtered = knifeStats.filterManufacturer(manu);
        filtered.printList();
    }

    // Bushings, Washers, Fixed, Folding
    public static void testFilterAction(String action) {
        MyList filtered = knifeStats.filterAction(action);
        filtered.printList();
    }

    public static void testFilterRating(boolean highest) {
        MyList filtered = knifeStats.filterRating(HOW_MANY, highest);
        filtered.printList();
    }

    public static void testFilterBladeLength(boolean longest) {
        MyList filtered = knifeStats.filterBladeLength(HOW_MANY, longest);
        filtered.printList();
    }

    public static void testFilterRatingBound(boolean higher) {
        MyList filtered = knifeStats.filterBoundRating(RATING_BOUND, higher);
        filtered.printList();
    }

    public static void testFilterBladeLengthBound(boolean higher) {
        MyList filtered = knifeStats.filterBoundBladeLength(BLADE_LENGTH_BOUND, higher);
        filtered.printList();
    }

}