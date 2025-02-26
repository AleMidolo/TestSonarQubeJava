import java.util.ArrayList;
import java.util.List;

public class BroadcastFilter {

    private List<Object> filters;

    public BroadcastFilter() {
        this.filters = new ArrayList<>();
    }

    /**
     * 调用 {@link BroadcastFilter}
     * @param msg
     * @return
     */
    protected Object filter(Object msg) {
        for (Object filter : filters) {
            // Assuming filter is a function that takes an Object and returns an Object
            msg = applyFilter(filter, msg);
        }
        return msg;
    }

    private Object applyFilter(Object filter, Object msg) {
        // Placeholder for actual filter logic
        // This should be replaced with the actual implementation of how to apply the filter
        return msg; // Return the message unmodified for now
    }

    public void addFilter(Object filter) {
        filters.add(filter);
    }
}