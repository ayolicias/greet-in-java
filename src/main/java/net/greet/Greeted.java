package net.greet;

import java.util.HashMap;
import java.util.Map;


public class Greeted implements GreetedUser {

    public String greeted;

    Map< String, Integer > greetMap = new HashMap< String, Integer >();
    private int greetCounter = 1;

    @Override
    public String greetUser( String userName, String language ) {

        if (!greetMap.containsKey(userName)) {
            greetMap.put(userName, greetCounter);

        } else {
            int greetCounter = greetMap.get(userName);
            greetCounter++;
            greetMap.put(userName, greetCounter);
        }
        return userName;
    }

    @Override
    public String totalGreeted() {
        return String.valueOf(greetMap.size());
    }


    @Override
    public String reset( ) {
        System.out.println("reset names");
        greetMap.clear();

        return reset();
    }

    @Override
    public String greeted() throws Exception {

            return greetMap.toString();
        }


    @Override
    public Map< String, Integer > findUsers() throws Exception {
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
    public String help() {
    System.out.println("greet followed by the name and the language the user is to be greeted in a specific language, \n");
    System.out.println("greet followed by the name the user is to be greeted in a Default Language,\n");
    System.out.println("greeted should display a list of all users that has been greeted and how many time each user has been greeted,");
    System.out.println("\n" + "greeted followed by a username returns how many times that username have been greeted");
    System.out.println("counter returns a count of how many unique users has been greeted,\n");
    System.out.println("clear deletes of all users greeted and the reset the greet counter to 0,\n");
    System.out.println("clear followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n");
    System.out.println("exit exits the application,\n");
    System.out.println("help shows a user an overview of all possible commands.\n");
        return help();
    }

    @Override
    public String exit() {
        System.exit(0);
        return exit();
    }

    @Override
    public String greetedUser( String userName ) throws Exception {
        return String.valueOf(findUsers().size());
    }
}



















