package org;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Class636767861a6d9265ec01844c {
    private List<String> appenders;

    public Class636767861a6d9265ec01844c() {
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
        Class636767861a6d9265ec01844c manager = new Class636767861a6d9265ec01844c();
        manager.addAppender("ConsoleAppender");
        manager.addAppender("FileAppender");
        
        System.out.println("Appenders before removal: " + manager.getAppenders());
        manager.removeAppender("ConsoleAppender");
        System.out.println("Appenders after removal: " + manager.getAppenders());
    }
}