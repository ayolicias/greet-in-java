package net.greet;

import java.util.Map;

public interface GreetedUser {

    void greetUser(String userName, String language);
    int totalGreeted(String userName);
    void loadJdbcclass();

    String remove(String userName);

    void reset();

    int greeted();
    String findUser( String userName);
    int getGreetCounter( );
    void setGreetCounter( int greetCounter );

    }
