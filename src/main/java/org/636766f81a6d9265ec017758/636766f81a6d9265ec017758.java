@Override
public int hashCode() {
    // Using a prime number to reduce collisions
    final int prime = 31;
    int result = 1;
    // Assuming this class has fields that need to be included in the hash code
    // Example: result = prime * result + (field1 == null ? 0 : field1.hashCode());
    // Example: result = prime * result + (field2 == null ? 0 : field2.hashCode());
    return result;
}