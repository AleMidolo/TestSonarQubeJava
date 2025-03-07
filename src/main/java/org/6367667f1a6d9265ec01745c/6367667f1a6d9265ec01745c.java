import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;

public class ClassPathUtil {

    /**
     * किसी निर्देशिका में सभी जार फ़ाइलों को क्लासपाथ में जोड़ें, जिसे URL के एक वेक्टर के रूप में दर्शाया गया है।
     * 
     * @param cpV  क्लासपाथ URL का वेक्टर
     * @param dir  निर्देशिका जिसमें जार फ़ाइलें हैं
     */
    @SuppressWarnings("unchecked")
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Provided path is not a directory: " + dir);
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

        // Example of using the class loader with the updated classpath
        URLClassLoader classLoader = new URLClassLoader(classPath.toArray(new URL[0]), ClassLoader.getSystemClassLoader());
        Thread.currentThread().setContextClassLoader(classLoader);
    }
}