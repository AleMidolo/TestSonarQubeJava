import java.util.Stack;

public class DiagnosisReference {
    private static Stack<String> referenceStack = new Stack<>();

    /**
     * इस NDC के शीर्ष पर अंतिम निदान संदर्भ को देखता है बिना उसे हटाए। <p> लौटाई गई मान वह मान है जो अंतिम बार डाला गया था। यदि कोई संदर्भ उपलब्ध नहीं है, तो खाली स्ट्रिंग "" लौटाई जाती है।
     * @return String सबसे आंतरिक निदान संदर्भ।
     */
    public static String peek() {
        if (!referenceStack.isEmpty()) {
            return referenceStack.peek();
        } else {
            return "";
        }
    }

    // Optional: Method to push a new reference onto the stack
    public static void push(String reference) {
        referenceStack.push(reference);
    }

    // Optional: Method to pop the top reference from the stack
    public static String pop() {
        if (!referenceStack.isEmpty()) {
            return referenceStack.pop();
        } else {
            return "";
        }
    }
}