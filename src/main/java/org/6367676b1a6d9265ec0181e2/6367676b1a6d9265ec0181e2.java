import java.util.Collection;

public class MatchFinder {
    /** 
     * '<code>candidates</code>' में से पहला तत्व लौटाएं जो '<code>source</code>' में मौजूद है। यदि '<code>candidates</code>' में कोई तत्व '<code>source</code>' में नहीं है, तो <code>null</code> लौटाएं। पुनरावृत्ति का क्रम {@link Collection} कार्यान्वयन विशिष्ट है।
     * @param source स्रोत संग्रह
     * @param candidates खोजने के लिए उम्मीदवार
     * @return पहला मौजूद वस्तु, या यदि नहीं मिला तो <code>null</code>
     */
    public static Object findFirstMatch(Collection source, Collection candidates) {
        for (Object candidate : candidates) {
            if (source.contains(candidate)) {
                return candidate;
            }
        }
        return null;
    }
}