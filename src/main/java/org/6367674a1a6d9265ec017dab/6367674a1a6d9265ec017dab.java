import java.util.Comparator;

public class DoubleComparator implements Comparator<Double> {

  /**
  * Confronta due valori in virgola mobile. Restituisce 0 se sono uguali, -1 se {@literal o1 < o2}, 1 altrimenti
  * @param o1 il primo valore
  * @param o2 il secondo valore
  * @return 0 se sono uguali, -1 se {@literal o1 < o2}, 1 altrimenti
  */
  @Override
  public int compare(Double o1, Double o2) {
  if (o1.equals(o2)) {
  return 0;
  }
  return o1 < o2 ? -1 : 1;
  }
}