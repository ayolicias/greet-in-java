package net.greet;

import java.util.Map;

public interface GreetedUser {
    String greetUser(String userName, String language);
    String remove(String userName);
    String reset();
    String greeted() throws Exception;
    Map< String, Integer > findUsers() throws Exception;
    int totalGreeted( ) throws Exception;
    String help();
    String exit();
    String greetedUser( String userName ) throws Exception;
}
