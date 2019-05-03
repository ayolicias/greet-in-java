package net.greet;

public interface GreetedUser {

    void greetUser(String userName, String language);
    void totalGreeted( String userName);
    String remove(String userName);
    void reset();
    String greeted() throws Exception;
    void findUser(String userName) throws Exception;
    int totalGreeted( );
    int greetMap() ;
    void help();
    void exit();
}
