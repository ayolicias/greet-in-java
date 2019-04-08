package net.greet;

import java.util.Scanner;

public class Greet {
    String Name;
    String Language;

    public static void main( String[] args ) {

        Greeted greeter = new Greeted();
        Scanner scanner = new Scanner(System.in);

        boolean exit = true;

        while (exit) {
            System.out.println("Enter command"); //discriptive name

            String input = scanner.nextLine();

            String[] command = input.split(" ");
            if (input.equals("exit")) {
                exit = false;
                break;
            }

            if (command[0].equals("greet")) {
                String language = command[2].toUpperCase();
                Languages.valueOf(language).getGreets(command[1]);
                System.out.println(Languages.valueOf(language).getGreets(command[1])); //enums with values
                System.out.println(greeter.totalGreeted());

            } else if (command[0].equals("greeted")) {
                System.out.println(greeter.greeted());
            }

            else System.out.println("invalid");

        }

    }
}


