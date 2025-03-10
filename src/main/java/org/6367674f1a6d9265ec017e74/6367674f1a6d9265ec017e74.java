import java.util.Queue;

public class QueueToString {
    private Queue<?> queue;

    public QueueToString(Queue<?> queue) {
        this.queue = queue;
    }

    /**
     * 返回队列的文本表示。
     * @return 队列的文本表示。
     */
    @Override
    public String toString() {
        if (queue == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object element : queue) {
            sb.append(element);
            sb.append(", ");
        }
        if (!queue.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove the trailing ", "
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<String> queue = new java.util.LinkedList<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");

        QueueToString queueToString = new QueueToString(queue);
        System.out.println(queueToString.toString());
    }
}