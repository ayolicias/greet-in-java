package net.greet;
import java.sql.SQLException;
import java.util.Scanner;

public class Greet {

    public static void main( String[] args ) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String input = "";

        GreetedUser greetedUser = new JdbcGreeted();
        CommandProcessor commandProcessor = new CommandProcessor(greetedUser);

        while (!input.equals("exit")) {
            System.out.println("Enter command");
            input = scanner.nextLine();

            CommandExtractor commandExtractor = new CommandExtractor(input);
            System.out.println(commandProcessor.execute(commandExtractor));
        }
    }
}




