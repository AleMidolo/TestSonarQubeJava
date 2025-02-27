public class MyClass {
    
    private StringBuilder stringBuilder;

    public MyClass() {
        stringBuilder = new StringBuilder();
    }

    /** 
     * <p> Obtiene la cadena construida por este constructor. </p>
     * @return la cadena construida
     */
    public String toString() {
        return stringBuilder.toString();
    }

    // Additional methods to manipulate the stringBuilder can be added here
}