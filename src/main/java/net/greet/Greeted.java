package net.greet;

import java.util.HashMap;
import java.util.Map;


public class Greeted{

    Map< String, Integer> greetMap = new HashMap<>();


    public void greetUser(String userName, String language){
        if(!greetMap.containsKey(userName)){
            greetMap.put(userName, 1);

        } else {
            int greetCounter = greetMap.get(userName);
            greetCounter++;
            greetMap.put(userName, greetCounter);
        }

    }


    public int totalGreeted(){
//        int totalGreeted = 0;
//
//        for(Integer greetCounter: greetMap.values()){
//            totalGreeted += greetCounter;
//        }
        return greetMap.size();
    }

    public Map< String, Integer > greeted() {
        return greetMap;
    }
}


















