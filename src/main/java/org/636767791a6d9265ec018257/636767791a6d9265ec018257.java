import java.util.logging.LogRecord;
import javax.swing.SwingUtilities;

public class LogTable {

    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Code to add the log record message to the log table
                // For example, you might append it to a JTextArea or a JTable
                System.out.println("Log Message: " + lr.getMessage());
            }
        });
    }
}