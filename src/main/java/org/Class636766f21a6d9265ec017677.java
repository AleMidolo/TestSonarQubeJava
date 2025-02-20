package org;

public class Class636766f21a6d9265ec017677 {

    /** 
     * <p>Controlla se un valore <code>Boolean</code> è <i>non</i> <code>true</code>, gestendo <code>null</code> restituendo <code>true</code>.</p> 
     * <pre> 
     * Class636766f21a6d9265ec017677.isNotTrue(Boolean.TRUE)  = false 
     * Class636766f21a6d9265ec017677.isNotTrue(Boolean.FALSE) = true 
     * Class636766f21a6d9265ec017677.isNotTrue(null)          = true 
     * </pre>
     * @param bool  il booleano da controllare, null restituisce <code>true</code>
     * @return <code>true</code> se l'input è null o false
     * @since 2.3
     */
    public static boolean isNotTrue(Boolean bool) {
        return bool == null || !bool;
    }

    public static void main(String[] args) {
        System.out.println(isNotTrue(Boolean.TRUE));  // false
        System.out.println(isNotTrue(Boolean.FALSE)); // true
        System.out.println(isNotTrue(null));           // true
    }
}