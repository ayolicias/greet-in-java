package net.greet;

public interface GreetedUser {
    int totalGreeted( int greet_Counter );
    void greetUser(String userName, String language);

    boolean greeted( );

    void reset( );

    void remove( String s );
}
