import java.util.Objects;

public class ArrayUtils {
  
  /**
  * Array vuoto costante di Double da riutilizzare
  */
  public static final Double[] EMPTY_DOUBLE_ARRAY = new Double[0];

  /**
  * <p>Tecnica di programmazione difensiva per cambiare un riferimento <code>null</code> in uno vuoto.</p>
  * <p>Questo metodo restituisce un array vuoto per un array di input <code>null</code>.</p>
  * <p>Come tecnica di ottimizzazione della memoria, un array vuoto passato verrà sovrascritto con i riferimenti vuoti <code>public static</code> in questa classe.</p>
  * @param array  l'array da controllare per <code>null</code> o vuoto
  * @return lo stesso array, array vuoto <code>public static</code> se l'input è <code>null</code> o vuoto
  * @since 2.5
  */
  public static Double[] nullToEmpty(final Double[] array) {
  if (array == null || array.length == 0) {
  return EMPTY_DOUBLE_ARRAY;
  }
  return array;
  }
}