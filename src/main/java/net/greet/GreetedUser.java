package net.greet;

import java.util.Map;

public interface GreetedUser {
    void greetUser(String userName, String language);
    String remove(String userName);
    void reset();
    String greeted() throws Exception;
    Map< String, Integer > findUsers() throws Exception;
    int totalGreeted( ) throws Exception;
    void help();
    void exit();
    String greetedUser( String userName ) throws Exception;
}
