import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> list;
    
    public Solution() {
        list = new ArrayList<>();
    }
    
    /**
     * 从集合中移除一个值。如果集合中包含指定的元素，则返回真。
     */
    public boolean remove(int val) {
        // Convert primitive int to Integer object since List stores objects
        Integer element = Integer.valueOf(val);
        
        // Try to remove the element and return whether it was present
        return list.remove(element);
    }
}