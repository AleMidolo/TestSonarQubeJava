import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {

    /**
     * Aggiunge un messaggio di registrazione da visualizzare nella LogTable. Questo metodo è thread-safe in quanto invia le richieste al SwingThread anziché elaborarle direttamente.
     */
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Qui puoi aggiungere il codice per aggiornare la LogTable con il nuovo LogRecord
                // Ad esempio:
                // logTableModel.addLogRecord(lr);
                System.out.println("LogRecord aggiunto: " + lr.getMessage());
            }
        });
    }
}