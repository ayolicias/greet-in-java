package net.greet;

import java.sql.SQLException;

public interface GreetedUser {

    void greetUser(String userName, String language);
    int totalGreeted(String userName);

    int greeted( );

    void reset( );

    void remove( String s );
}
