package net.greet;

import java.sql.SQLException;
import java.util.Scanner;

public class Greet {
//    public String Name;
//    public String Language;

    public static void main( String[] args ) throws Exception {

//        GreetedUser greeter = new JdbcGreeted();

        Scanner scanner = new Scanner(System.in);
        String input = "";
       CommandProcessor commandProcessor = new CommandProcessor();

        while (!input.equals("exit")) {
            System.out.println("Enter command");
            input = scanner.nextLine();

            CommandExtractor commandExtractor = new CommandExtractor(input);
            System.out.println(commandProcessor.execute(commandExtractor));
        }
    }
}




