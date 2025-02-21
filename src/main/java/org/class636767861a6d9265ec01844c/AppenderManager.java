package org.class636767861a6d9265ec01844c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppenderManager {
    private List<String> appenders;

    public AppenderManager() {
        this.appenders = new ArrayList<>();
    }

    /** 
     * Rimuove l'appender con il nome passato come parametro dalla lista degli appenders.  
     */
    public void removeAppender(String name) {
        Iterator<String> iterator = appenders.iterator();
        while (iterator.hasNext()) {
            String appender = iterator.next();
            if (appender.equals(name)) {
                iterator.remove();
                break;
            }
        }
    }

    public void addAppender(String name) {
        appenders.add(name);
    }

    public List<String> getAppenders() {
        return appenders;
    }

    public static void main(String[] args) {
        AppenderManager manager = new AppenderManager();
        manager.addAppender("ConsoleAppender");
        manager.addAppender("FileAppender");
        
        System.out.println("Appenders before removal: " + manager.getAppenders());
        manager.removeAppender("ConsoleAppender");
        System.out.println("Appenders after removal: " + manager.getAppenders());
    }
}