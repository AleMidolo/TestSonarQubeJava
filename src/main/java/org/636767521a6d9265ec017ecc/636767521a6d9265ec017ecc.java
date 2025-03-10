import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.util.Pair;

public class BoxSplitter {

    /**
     * Divide una caja a lo largo del eje x en dos cajas iguales.
     * @param box la caja a dividir
     * @return un par con las dos cajas resultantes
     */
    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        double minX = box.getMinX();
        double minY = box.getMinY();
        double maxX = box.getMaxX();
        double maxY = box.getMaxY();
        double width = maxX - minX;
        double height = maxY - minY;

        // Dividir la caja a lo largo del eje x
        double midX = minX + width / 2.0;

        Box2D leftBox = new Box2D(minX, minY, midX, maxY);
        Box2D rightBox = new Box2D(midX, minY, maxX, maxY);

        return new Pair<>(leftBox, rightBox);
    }

    public static void main(String[] args) {
        Box2D box = new Box2D(0, 0, 10, 5);
        Pair<Box2D, Box2D> splitBoxes = splitAlongXAxis(box);
        System.out.println("Left Box: " + splitBoxes.getKey());
        System.out.println("Right Box: " + splitBoxes.getValue());
    }
}

class Box2D {
    private double minX;
    private double minY;
    private double maxX;
    private double maxY;

    public Box2D(double minX, double minY, double maxX, double maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public double getMinX() {
        return minX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    @Override
    public String toString() {
        return "Box2D{" +
                "minX=" + minX +
                ", minY=" + minY +
                ", maxX=" + maxX +
                ", maxY=" + maxY +
                '}';
    }
}