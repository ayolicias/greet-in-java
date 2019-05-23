package net.greet;

import java.util.HashMap;
import java.util.Map;


public class Greeted implements GreetedUser {

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


        switch (Languages.valueOf(language)){
            case english:
                return Languages.valueOf(language).getGreets() + " " + userName;
            case tswana:
                return Languages.valueOf(language).getGreets() + " " + userName;
            case isixhosa:
                return Languages.valueOf(language).getGreets()+ " " + userName;
            case afrikaans:
                return Languages.valueOf(language).getGreets()+ " " + userName;
            default:
                return Languages.valueOf("tswana").getGreets()+ " " + userName;
        }

    }

    @Override
    public String totalGreeted() {
        return "";
    }


    @Override
    public String reset( ) {
        System.out.println("reset names");
        greetMap.clear();

        return " ";
    }

    @Override
    public String greeted() throws Exception {

            return greetMap.toString();
        }


    @Override
    public Map< String, Integer > findUsers() throws Exception {
        return findUsers();
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

    @Override
     public String help() {
        return "help shows a user an overview of all possible commands\n" +
                "greet followed by the name and the language the user is to be greeted in a specific language, \n " +
                "greet followed by the name the user is to be greeted in a Default Language,\n " +
                "greeted should display a list of all users that has been greeted and how many time each user has been greeted\n " +
                "greeted followed by a username returns how many times that username have been greeted\n " +
                "counter returns a count of how many unique users has been greeted,\n " +
                "clear deletes of all users greeted and the reset the greet counter to 0,\n " +
                "clear followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n " +
                "exit exits the application,\n ";
    }
    @Override
    public String exit() {
        System.out.println("exit");
        System.exit(0);
        return exit();
    }

    @Override
    public String greetedUser( String userName ) throws Exception {
        return String.valueOf(findUsers().size());
    }
}



















