import java.util.function.Predicate;

public class OuterFaceCirculator {
    private Node current;

    public OuterFaceCirculator(Node start) {
        this.current = start;
    }

    public Node getCurrent() {
        return current;
    }

    public void next(int dir) {
        // Assuming dir is either 0 (clockwise) or 1 (counter-clockwise)
        if (dir == 0) {
            current = current.getNextClockwise();
        } else {
            current = current.getNextCounterClockwise();
        }
    }

    public void previous(int dir) {
        // Assuming dir is either 0 (clockwise) or 1 (counter-clockwise)
        if (dir == 0) {
            current = current.getPreviousClockwise();
        } else {
            current = current.getPreviousCounterClockwise();
        }
    }
}

public class Node {
    private Node nextClockwise;
    private Node nextCounterClockwise;

    public Node getNextClockwise() {
        return nextClockwise;
    }

    public void setNextClockwise(Node nextClockwise) {
        this.nextClockwise = nextClockwise;
    }

    public Node getNextCounterClockwise() {
        return nextCounterClockwise;
    }

    public void setNextCounterClockwise(Node nextCounterClockwise) {
        this.nextCounterClockwise = nextCounterClockwise;
    }

    public Node getPreviousClockwise() {
        // Assuming a doubly linked structure
        return nextCounterClockwise;
    }

    public Node getPreviousCounterClockwise() {
        // Assuming a doubly linked structure
        return nextClockwise;
    }
}

public class Graph {
    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);
        Node current = start;

        do {
            if (predicate.test(current)) {
                return circulator;
            }
            circulator.next(dir);
            current = circulator.getCurrent();
        } while (current != stop);

        return circulator;
    }
}