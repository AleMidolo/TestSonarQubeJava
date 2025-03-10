import java.util.Stack;

public class FrameStack {
    private Stack<String> stack;

    public FrameStack() {
        stack = new Stack<>();
    }

    /**
     * 根据给定的描述符，从输出帧堆栈中弹出相应数量的抽象类型。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则会弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        // 判断是否是方法描述符
        if (descriptor.startsWith("(")) {
            // 方法描述符，解析参数类型
            int endIndex = descriptor.indexOf(')');
            if (endIndex == -1) {
                throw new IllegalArgumentException("Invalid method descriptor: " + descriptor);
            }
            String params = descriptor.substring(1, endIndex);
            int paramCount = countParameters(params);
            for (int i = 0; i < paramCount; i++) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        } else {
            // 单个类型描述符
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
    }

    /**
     * 计算参数描述符中的参数数量。
     * @param params 参数描述符
     * @return 参数数量
     */
    private int countParameters(String params) {
        int count = 0;
        int index = 0;
        while (index < params.length()) {
            char c = params.charAt(index);
            if (c == 'L') {
                // 对象类型，跳过直到 ';'
                int endIndex = params.indexOf(';', index);
                if (endIndex == -1) {
                    throw new IllegalArgumentException("Invalid parameter descriptor: " + params);
                }
                index = endIndex + 1;
            } else if (c == '[') {
                // 数组类型，跳过所有 '['
                while (index < params.length() && params.charAt(index) == '[') {
                    index++;
                }
                if (index < params.length() && params.charAt(index) == 'L') {
                    // 对象数组类型，跳过直到 ';'
                    int endIndex = params.indexOf(';', index);
                    if (endIndex == -1) {
                        throw new IllegalArgumentException("Invalid parameter descriptor: " + params);
                    }
                    index = endIndex + 1;
                } else {
                    // 基本类型数组
                    index++;
                }
            } else {
                // 基本类型
                index++;
            }
            count++;
        }
        return count;
    }

    // 测试代码
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.stack.push("int");
        frameStack.stack.push("float");
        frameStack.stack.push("java/lang/Object");

        frameStack.pop("(IFLjava/lang/Object;)V");

        System.out.println(frameStack.stack); // 输出: []
    }
}