public class Request {
    private String content;

    public Request(String content) {
        this.content = content;
    }

    /** 
     * अनुरोध की सामग्री की लंबाई प्राप्त करें।
     * @return अनुरोध की सामग्री की लंबाई।
     * @since 1.3
     */
    public long contentLength() {
        return content != null ? content.length() : 0;
    }

    public static void main(String[] args) {
        Request request = new Request("Hello, World!");
        System.out.println("Content Length: " + request.contentLength());
    }
}