import org.slf4j.MDC;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class NDC {
  private static final ThreadLocal<Deque<String>> localDeque = new ThreadLocal<Deque<String>>() {
  @Override 
  protected Deque<String> initialValue() {
  return new ConcurrentLinkedDeque<>();
  }
  };

  /** 
  * Osserva l'ultimo contesto diagnostico in cima a questo NDC senza rimuoverlo. <p>Il valore restituito è il valore che è stato inserito per ultimo. Se non è disponibile alcun contesto, viene restituita la stringa vuota "".
  * @return String Il contesto diagnostico più interno.
  */
  public static String peek() {
  Deque<String> deque = localDeque.get();
  if (deque != null && !deque.isEmpty()) {
  return deque.peek();
  }
  return "";
  }
}