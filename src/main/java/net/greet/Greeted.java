package net.greet;

import java.util.HashMap;
import java.util.Map;


public class Greeted implements GreetedUser {

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

    @Override
    public int totalGreeted( String userName ) {

        return this.totalGreeted( userName);
    }

//    @Override
//    public int totalGreeted( ) {
//        return greetMap.size();
//    }

    @Override
    public int totalGreeted( ) {

        return greetMap.size();
    }

    @Override
    public void reset( ) {
        System.out.println("reset names");
        greetMap.clear();

    }

    @Override
    public String greeted( ) {
        return "0";
    }

    //    @Override
//    public int greeted( ) {
//        return 0;
//    }
    @Override
    public void findUser(String userName) throws Exception {
        if (userName.isEmpty ( ) == true) {
            System.out.println ( "no users have been greeted" );
        } else {
            System.out.println ( userName );
        }
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


}



















