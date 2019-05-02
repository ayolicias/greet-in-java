package net.greet;

public interface GreetedUser {

    void greetUser(String userName, String language);
    int totalGreeted(String userName);
    String remove(String userName);
    void reset();
    String greeted();
    void findUser(String userName) throws Exception;
    int totalGreeted( );
}
