package practice.knifemanager.knife;

public abstract class Knife implements KnifeComparable {

    private final String name;
    private final String action;
    private final double bladeLength;
    private final String manufacturer;
    private double rating;

    public Knife(String name, String manufacturer, String action, double bladeLength, double rating) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.action = action;
        this.bladeLength = bladeLength;
        setRating(rating); // Call the setter to ensure the rating is within the valid range
    }

    public String getName() {
        return name;
    }

    public String getAction() {
        return action;
    }

    public double getBladeLength() {
        return bladeLength;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        // Ensure the rating is within the valid range (0 - 5.0)
        if (rating < 0 || rating > 5.0) {
            throw new IllegalArgumentException("Rating must be between 0 and 5.0");
        }
        this.rating = rating;
    }

    public static Knife[] convertToKnifeArray(Object[] objectArray) {
        Knife[] knifeArray = new Knife[objectArray.length];
        for (int i = 0; i < objectArray.length; i++) {
            if (objectArray[i] instanceof Knife) {
                knifeArray[i] = (Knife) objectArray[i];
            } else {
                throw new ClassCastException();
            }
        }
        return knifeArray;
    }

    @Override
    public String toString() {
        return "[(" + manufacturer + ") " + getClass().getSimpleName() + ": "
                + name.toUpperCase() + ", action: " + action + ", blade length: "
                + String.format("%.2f cm", bladeLength)
                + ", rating: " + String.format("%.1f", rating) + "]";
    }

    @Override
    public int compareTo(Knife another) {
        return Double.compare(rating, another.rating);
    }

}
