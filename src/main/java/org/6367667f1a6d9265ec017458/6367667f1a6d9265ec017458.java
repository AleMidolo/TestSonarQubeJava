import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereFramework {
    private java.util.Map<String, AtmosphereHandler> handlers = new java.util.HashMap<>();

    /**
     * 移除一个 {@link AtmosphereHandler}。
     * @param mapping 在调用 {@link #addAtmosphereHandler(String, AtmosphereHandler)} 时使用的映射；
     * @return 如果成功移除则返回真
     */
    public boolean removeAtmosphereHandler(String mapping) {
        if (handlers.containsKey(mapping)) {
            handlers.remove(mapping);
            return true;
        }
        return false;
    }

    /**
     * 添加一个 {@link AtmosphereHandler}。
     * @param mapping 映射
     * @param handler 处理器
     */
    public void addAtmosphereHandler(String mapping, AtmosphereHandler handler) {
        handlers.put(mapping, handler);
    }
}