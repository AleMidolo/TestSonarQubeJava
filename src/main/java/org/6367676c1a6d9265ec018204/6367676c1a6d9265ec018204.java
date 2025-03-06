import java.util.ArrayList;
import java.util.List;

public class ArrayConcatenator {

    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        if (array1 == null && array2 == null) {
            return null;
        }

        List<String> result = new ArrayList<>();

        if (array1 != null) {
            for (String s : array1) {
                result.add(s);
            }
        }

        if (array2 != null) {
            for (String s : array2) {
                result.add(s);
            }
        }

        if (array1 != null && array2 != null) {
            int overlapLength = Math.min(array1.length, array2.length);
            for (int i = 0; i < overlapLength; i++) {
                result.add(array1[i] + array2[i]);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] array1 = {"a", "b", "c"};
        String[] array2 = {"1", "2", "3", "4"};

        String[] result = concatenateStringArrays(array1, array2);
        for (String s : result) {
            System.out.println(s);
        }
    }
}