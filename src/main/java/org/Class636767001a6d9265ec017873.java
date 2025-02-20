package org;

public class Class636767001a6d9265ec017873 {
    
    /** 
     * <p>Inverte una Stringa come per {@link StringBuilder#reverse()}.</p> 
     * <p>Una Stringa <code>null</code> restituisce <code>null</code>.</p> 
     * <pre> Class636767001a6d9265ec017873.reverse(null)  = null Class636767001a6d9265ec017873.reverse("")    = "" Class636767001a6d9265ec017873.reverse("bat") = "tab" </pre>
     * @param str  la Stringa da invertire, può essere null
     * @return la Stringa invertita, <code>null</code> se l'input è una Stringa null
     */
    public static String reverse(final String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse(null));  // Output: null
        System.out.println(reverse(""));    // Output: ""
        System.out.println(reverse("bat"));  // Output: "tab"
    }
}