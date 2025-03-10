import java.io.IOException;
import java.io.InputStream;

public class TagReader {
    private InputStream inputStream;

    public TagReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * 尝试读取一个字段标签，如果到达文件末尾则返回零。协议消息解析器使用此方法读取标签，因为协议消息可以合法地在任何标签出现的地方结束，而零不是有效的标签编号。
     *
     * @return 读取到的标签值，如果到达文件末尾则返回0
     * @throws IOException 如果发生I/O错误
     */
    public int readTag() throws IOException {
        int tag = inputStream.read();
        return tag == -1 ? 0 : tag;
    }
}