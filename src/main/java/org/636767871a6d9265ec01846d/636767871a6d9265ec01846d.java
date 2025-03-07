import java.io.File;

public class ConfigurationDirectoryCreator {

    /**
     * वह निर्देशिका बनाता है जहाँ MRU फ़ाइल सूची लिखी जाएगी। "lf5" निर्देशिका Windows 2000 मशीनों पर Documents और Settings निर्देशिका में बनाई जाती है और सभी अन्य प्लेटफार्मों पर जहाँ भी user.home वेरिएबल इंगित करता है।
     */
    public static void createConfigurationDirectory() {
        String osName = System.getProperty("os.name").toLowerCase();
        String userHome = System.getProperty("user.home");
        String configDirPath;

        if (osName.contains("windows 2000")) {
            configDirPath = userHome + File.separator + "Documents and Settings" + File.separator + "lf5";
        } else {
            configDirPath = userHome + File.separator + "lf5";
        }

        File configDir = new File(configDirPath);
        if (!configDir.exists()) {
            boolean created = configDir.mkdirs();
            if (created) {
                System.out.println("Configuration directory created at: " + configDirPath);
            } else {
                System.out.println("Failed to create configuration directory at: " + configDirPath);
            }
        } else {
            System.out.println("Configuration directory already exists at: " + configDirPath);
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}