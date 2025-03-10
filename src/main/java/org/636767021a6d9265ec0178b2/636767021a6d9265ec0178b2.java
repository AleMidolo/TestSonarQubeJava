import java.util.Stack;

public class FrameStack {
    private Stack<Object> stack;

    public FrameStack() {
        this.stack = new Stack<>();
    }

    /**
     * 从输出帧栈中弹出与给定描述符所描述的抽象类型数量。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        int count = getTypeCount(descriptor);
        for (int i = 0; i < count; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                throw new IllegalStateException("Stack underflow: not enough elements to pop.");
            }
        }
    }

    /**
     * 根据描述符计算需要弹出的类型数量。
     * @param descriptor 类型或方法描述符。
     * @return 需要弹出的类型数量。
     */
    private int getTypeCount(String descriptor) {
        int count = 0;
        int index = 0;
        while (index < descriptor.length()) {
            char c = descriptor.charAt(index);
            if (c == 'L') {
                // 对象类型，跳过直到 ';'
                while (index < descriptor.length() && descriptor.charAt(index) != ';') {
                    index++;
                }
                count++;
            } else if (c == '[') {
                // 数组类型，跳过所有 '['
                while (index < descriptor.length() && descriptor.charAt(index) == '[') {
                    index++;
                }
                // 处理数组元素类型
                if (index < descriptor.length()) {
                    char elementType = descriptor.charAt(index);
                    if (elementType == 'L') {
                        // 对象数组，跳过直到 ';'
                        while (index < descriptor.length() && descriptor.charAt(index) != ';') {
                            index++;
                        }
                    }
                }
                count++;
            } else if (c == 'D' || c == 'J') {
                // double 或 long 类型，占用两个槽位
                count += 2;
            } else {
                // 其他基本类型，占用一个槽位
                count++;
            }
            index++;
        }
        return count;
    }

    // 示例用法
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.stack.push(1);
        frameStack.stack.push(2.0);
        frameStack.stack.push("Hello");

        frameStack.pop("I"); // 弹出 int 类型
        frameStack.pop("D"); // 弹出 double 类型
        frameStack.pop("Ljava/lang/String;"); // 弹出 String 类型
    }
}