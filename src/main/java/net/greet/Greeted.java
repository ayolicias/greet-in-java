package net.greet;

import java.util.HashMap;
import java.util.Map;


public class Greeted{

    Map< String, Integer> greetMap = new HashMap<String, Integer>();
    private  int greetCounter =1;


    public void greetUser(String userName, String language){

        if(!greetMap.containsKey(userName)){
            greetMap.put(userName, greetCounter);

        }
        else {
            int greetCounter = greetMap.get(userName);
            greetCounter++;
            greetMap.put(userName, greetCounter);

        }

    }

    public int totalGreeted( ){

        return greetMap.size();
    }

    public Map< String, Integer > greeted() {
        return greetMap;
    }

    public void reset(){
      System.out.println("reset names");
        greetMap.clear();

    }
    public void remove(String userName){

        if (greetMap.containsKey(userName)){
            greetMap.remove(userName);
            System.out.println("cleared " + userName);
        }
        else{
            System.out.println("name is not in the list");

        }

    }

    public void getGreets( ) {
        this.greeted();
    }
}



















