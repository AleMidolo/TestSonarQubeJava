import java.util.Stack;

public class NDC {
    private static final ThreadLocal<Stack<String>> diagnosticContexts = new ThreadLocal<Stack<String>>() {
        @Override 
        protected Stack<String> initialValue() {
            return new Stack<String>();
        }
    };

    /**
     * 查看此 NDC 顶部的最后诊断上下文，而不将其移除。<p>返回的值是最后推入的值。如果没有可用的上下文，则返回空字符串 ""。
     * @return String 最内层的诊断上下文。
     */
    public static String peek() {
        Stack<String> stack = diagnosticContexts.get();
        if (stack != null && !stack.isEmpty()) {
            return stack.peek();
        }
        return "";
    }
}