package org;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigurationInitializer {

    /** 
     * inizializza la configurazione, ad esempio controlla il percorso di distribuzione
     */
    public void init() {
        String distributionPath = "path/to/distribution"; // Replace with actual path
        Path path = Paths.get(distributionPath);
        
        if (Files.exists(path) && Files.isDirectory(path)) {
            System.out.println("La configurazione è stata inizializzata con successo.");
        } else {
            System.out.println("Errore: il percorso di distribuzione non esiste o non è una directory.");
        }
    }

    public static void main(String[] args) {
        ConfigurationInitializer initializer = new ConfigurationInitializer();
        initializer.init();
    }
}