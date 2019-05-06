package net.greet;

import java.util.HashMap;
import java.util.Map;


public class Greeted implements GreetedUser {

    public String greeted;

    Map< String, Integer > greetMap = new HashMap< String, Integer >();
    private int greetCounter = 1;

    @Override
    public void greetUser( String userName, String language ) {

        if (!greetMap.containsKey(userName)) {
            greetMap.put(userName, greetCounter);

        } else {
            int greetCounter = greetMap.get(userName);
            greetCounter++;
            greetMap.put(userName, greetCounter);

        }

    }
//
//    @Override
//    public int totalGreeted( String userName ) {
//        return 0;
//    }


    @Override
    public int totalGreeted() {
        return greetMap.size();
    }


    @Override
    public void reset( ) {
        System.out.println("reset names");
        greetMap.clear();

    }

    @Override
    public String greeted() throws Exception {

            return greetMap.toString();
        }


    @Override
    public Map< String, Integer > findUsers() throws Exception {
//        if ((userName.isEmpty() == true)) {
//            System.out.println ( "no users have been greeted" );
//        } else {
//            System.out.println (userName );
//        }
        return null;
    }


    @Override
    public String remove(String userName){

        if (greetMap.containsKey(userName)){
            greetMap.remove(userName);
            System.out.println("cleared " + userName);

             this.remove(userName);

        }
        return userName + " is not in the list";

    }


    public int greetMap() {
        return greetMap.size();
    }

    @Override
    public void help() {
    System.out.println("greet followed by the name and the language the user is to be greeted in a specific language, \n");
    System.out.println("greet followed by the name the user is to be greeted in a Default Language,\n");
    System.out.println("greeted should display a list of all users that has been greeted and how many time each user has been greeted,");
    System.out.println("\n" + "greeted followed by a username returns how many times that username have been greeted");
    System.out.println("counter returns a count of how many unique users has been greeted,\n");
    System.out.println("clear deletes of all users greeted and the reset the greet counter to 0,\n");
    System.out.println("clear followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n");
    System.out.println("exit exits the application,\n");
    System.out.println("help shows a user an overview of all possible commands.\n");
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public String greetedUser( String userName ) throws Exception {
        return String.valueOf(findUsers().size());
    }
}



















