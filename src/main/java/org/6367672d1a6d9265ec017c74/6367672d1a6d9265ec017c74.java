import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        this.set = new HashSet<>();
    }

    /**
     * सेट से एक मान को हटाता है। यदि सेट में निर्दिष्ट तत्व था, तो true लौटाता है।
     * 
     * @param val हटाया जाने वाला मान
     * @return true यदि मान सेट में था और हटा दिया गया, अन्यथा false
     */
    public boolean remove(int val) {
        return set.remove(val);
    }
}