private void pop(final int elements) {
    // Assuming there is a Stack to represent the output frame stack
    Stack<Object> outputFrameStack = new Stack<>();

    // Check if the number of elements to pop is valid
    if (elements < 0) {
        throw new IllegalArgumentException("Number of elements to pop must be non-negative.");
    }

    // Pop the specified number of elements from the stack
    for (int i = 0; i < elements; i++) {
        if (!outputFrameStack.isEmpty()) {
            outputFrameStack.pop();
        } else {
            throw new IllegalStateException("Not enough elements in the stack to pop.");
        }
    }
}