import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        set = new HashSet<>();
    }

    /**
     * सेट से एक मान को हटाता है। यदि सेट में निर्दिष्ट तत्व था, तो true लौटाता है।
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    // Optional: Add a method to add elements to the set for testing
    public void add(int val) {
        set.add(val);
    }
}