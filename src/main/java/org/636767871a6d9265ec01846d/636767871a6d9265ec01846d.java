import java.io.File;

public class ConfigurationDirectoryCreator {

    /** 
     * Crea la directory in cui verrà scritta la lista dei file MRU. La directory "lf5" viene creata nella directory Documenti e Impostazioni sui computer Windows 2000 e ovunque punti la variabile user.home su tutte le altre piattaforme.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        File configDir = new File(userHome, "lf5");

        if (!configDir.exists()) {
            boolean created = configDir.mkdirs();
            if (created) {
                System.out.println("Directory created: " + configDir.getAbsolutePath());
            } else {
                System.out.println("Failed to create directory: " + configDir.getAbsolutePath());
            }
        } else {
            System.out.println("Directory already exists: " + configDir.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}