import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {

    /**
     * 将给定的相对路径应用于给定路径，假设使用标准的Java文件夹分隔符（即“/”分隔符）。
     * @param path 起始路径（通常是完整的文件路径）
     * @param relativePath 要应用的相对路径（相对于上述完整文件路径）
     * @return 应用相对路径后得到的完整文件路径
     */
    public static String applyRelativePath(String path, String relativePath) {
        Path basePath = Paths.get(path);
        Path resolvedPath = basePath.resolve(relativePath);
        return resolvedPath.normalize().toString();
    }

    public static void main(String[] args) {
        String path = "/usr/local/bin";
        String relativePath = "../lib/java";
        String result = applyRelativePath(path, relativePath);
        System.out.println(result);  // 输出: /usr/local/lib/java
    }
}