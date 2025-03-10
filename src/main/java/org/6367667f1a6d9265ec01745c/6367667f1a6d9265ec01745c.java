import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

public class ClassPathUtil {

    /**
     * 将目录中的所有jar文件添加到类路径中，表示为URL的Vector。
     * 
     * @param cpV 用于存储URL的Vector
     * @param dir 要扫描的目录路径
     */
    @SuppressWarnings("unchecked")
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("提供的路径不是一个有效的目录: " + dir);
        }

        File[] files = directory.listFiles((dir1, name) -> name.endsWith(".jar"));
        if (files != null) {
            for (File file : files) {
                try {
                    URL url = file.toURI().toURL();
                    cpV.add(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Vector<URL> classPath = new Vector<>();
        String directoryPath = "path/to/your/directory";
        addToClassPath(classPath, directoryPath);

        // 打印添加的URL
        for (URL url : classPath) {
            System.out.println(url);
        }
    }
}