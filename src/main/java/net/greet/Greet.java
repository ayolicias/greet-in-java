package net.greet;

import java.sql.SQLException;
import java.util.Scanner;

public class Greet {
//    public String Name;
//    public String Language;

    public static void main( String[] args ) throws SQLException {

//        GreetedUser greeter = new Greeted();
        GreetedUser greeter = new JdbcGreeted();

        Scanner scanner = new Scanner(System.in);

        boolean exit = true;

        while (exit) {
            System.out.println("Enter command");

            String input = scanner.nextLine();

            String[] command = input.split(" ");
            if (input.equals("exit")) {
                exit = false;
                break;
            }

            if (command[0].equals("greet")) {
                try {
                    String language = command[2].toUpperCase();
                    Languages.valueOf(language).getGreets(command[1]);
                    System.out.println(Languages.valueOf(language).getGreets(command[1]));
                    greeter.greetUser(command[1], language);

                    System.out.println(greeter.totalGreeted());

                } catch (ArrayIndexOutOfBoundsException e) {
                    String language = "TSWANA";
                    Languages.valueOf(language).getGreets(command[1]);

                    System.out.println(Languages.valueOf(language).getGreets(command[1]));
                    greeter.greetUser(command[1], language);
                }

            } else if (command[0].equals("greeted")) {
                System.out.println(greeter.greeted());
            } else if (command[0].equals("reset")) {
                greeter.reset();

            }
            else if (command[0].equals("clear")){
                greeter.remove(command[1]);

            }

            else System.out.println("invalid");

        }

    }
}




