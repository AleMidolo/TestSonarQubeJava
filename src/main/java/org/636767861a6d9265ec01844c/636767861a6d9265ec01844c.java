import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Logger {
  private List<Appender> appenders;
  
  public Logger() {
  appenders = new ArrayList<>();
  }
  
  /** 
  * Rimuove l'appender con il nome passato come parametro dalla lista degli appenders.  
  */
  public void removeAppender(String name) {
  if (name == null) {
  return;
  }
  
  Iterator<Appender> iterator = appenders.iterator();
  while (iterator.hasNext()) {
  Appender appender = iterator.next();
  if (name.equals(appender.getName())) {
  iterator.remove();
  break;
  }
  }
  }
}

interface Appender {
  String getName();
}