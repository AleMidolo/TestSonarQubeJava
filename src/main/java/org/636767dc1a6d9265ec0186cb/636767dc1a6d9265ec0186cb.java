import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ConfigurationManager {
    private static final Logger LOGGER = Logger.getLogger(ConfigurationManager.class.getName());
    private static final String DISTRIBUTION_PATH = "dist/";
    
    /**
     * inicializa la configuración, como verificar la ruta de distribución
     */
    public void init() {
        try {
            // Verificar si existe el directorio de distribución
            File distributionDir = new File(DISTRIBUTION_PATH);
            
            if (!distributionDir.exists()) {
                // Crear el directorio si no existe
                if (distributionDir.mkdirs()) {
                    LOGGER.info("Directorio de distribución creado exitosamente");
                } else {
                    LOGGER.severe("No se pudo crear el directorio de distribución");
                }
            }
            
            // Verificar permisos de escritura
            if (!distributionDir.canWrite()) {
                LOGGER.warning("El directorio de distribución no tiene permisos de escritura");
            }
            
            // Otras inicializaciones de configuración pueden ir aquí
            
        } catch (SecurityException e) {
            LOGGER.log(Level.SEVERE, "Error de seguridad al inicializar la configuración", e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al inicializar la configuración", e);
        }
    }
}