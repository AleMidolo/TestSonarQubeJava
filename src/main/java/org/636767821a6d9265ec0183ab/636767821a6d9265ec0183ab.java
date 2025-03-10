public class Example {
    private Throwable thrown;

    public Example(Throwable thrown) {
        this.thrown = thrown;
    }

    public boolean hasThrown() {
        if (thrown == null) {
            return false;
        }
        String thrownString = thrown.toString();
        return thrownString != null && !thrownString.isEmpty();
    }

    public static void main(String[] args) {
        // Example usage
        Example example = new Example(new RuntimeException("Test Exception"));
        System.out.println(example.hasThrown()); // Should print true

        Example example2 = new Example(null);
        System.out.println(example2.hasThrown()); // Should print false
    }
}