package net.greet;

import sun.rmi.runtime.NewThreadAction;

import java.util.Scanner;

public class greet {

    String Name;
    String Language;
    int Counter = 0;

    public void Greet( String Name, String Language ) {

        System.out.println(Name + ", " + Language);

        System.out.println("Please Enter your Name");
        Scanner Input = new Scanner(System.in);
//        Name = Input type;


        if (Name == "Ziya") {
        System.out.println("Molo"+Name+"Language");

        }
        if(Name == "Yaya"){
            System.out.println("Hi"+Name+"Language");
        }
        if (Name == "Anele"){
            System.out.println("Gemore"+Name+"Language");
        }
    }
}
