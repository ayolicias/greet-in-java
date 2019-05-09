package net.greet;

import org.h2.command.Command;

import java.util.Scanner;

public class commandProcessor{


    private static Greet greet;
//    Greet greet;

    public commandProcessor( Greet greet){
        commandProcessor.greet = greet;
    }

    public static void main( String[] args ) throws Exception {

        String getnames;
        String getlanguage;

//        GreetedUser greeter = new Greeted();
        GreetedUser greeter = new JdbcGreeted();

        Scanner scanner = new Scanner(System.in);


//        while (greet) {
            System.out.println("Enter command");

            String input = scanner.nextLine();

            String[] command = input.split("");
            if (input.equals("greet")) {

//                return greeter.greetUser(getnames, getlanguage);


            }

            }

}
