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

    public Throwable getThrown() {
        return thrown;
    }

    public static void main(String[] args) {
        // Example usage
        Example example = new Example(new RuntimeException("Error occurred"));
        System.out.println(example.hasThrown()); // Should print true
    }
}