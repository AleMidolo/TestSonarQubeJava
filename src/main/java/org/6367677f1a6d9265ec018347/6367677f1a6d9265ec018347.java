import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<Socket> clients = new ArrayList<>();

    /**
     * Invia un messaggio a ciascuno dei client in un formato compatibile con telnet.
     */
    public synchronized void send(final String message) {
        for (Socket client : clients) {
            try {
                OutputStream outputStream = client.getOutputStream();
                outputStream.write(message.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                // Gestisci l'eccezione, ad esempio rimuovendo il client dalla lista
                clients.remove(client);
                e.printStackTrace();
            }
        }
    }

    // Metodo per aggiungere un client alla lista
    public synchronized void addClient(Socket client) {
        clients.add(client);
    }

    // Metodo per rimuovere un client dalla lista
    public synchronized void removeClient(Socket client) {
        clients.remove(client);
    }
}