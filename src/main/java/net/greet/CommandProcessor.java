package net.greet;

import java.sql.SQLException;

public class CommandProcessor {

    JdbcGreeted greeter = new JdbcGreeted();

    private String language;
    private String name;

    public String execute( CommandExtractor commandExtractor ) throws SQLException {
        if (commandExtractor.getCommand().equals("greet")) {
            try {
                String language = commandExtractor.getLanguage().toLowerCase();
                Languages.valueOf(language).getGreets(commandExtractor.getLanguage());
                System.out.println(Languages.valueOf(language).getGreets(commandExtractor.getName()));
                greeter.greetUser(commandExtractor.getLanguage(), commandExtractor.getLanguage());

            } catch (ArrayIndexOutOfBoundsException e) {
                String language = "TSWANA";
                Languages.valueOf(language).getGreets(commandExtractor.getLanguage());

                System.out.println(Languages.valueOf(language).getGreets(commandExtractor.getLanguage()));
                greeter.greetUser(commandExtractor.getName(), commandExtractor.getLanguage());
            }

        }
        else if (commandExtractor.getCommand().equals("greeted")) {
            System.out.println("greeted");

            try {
                if (!commandExtractor.getName().isEmpty()) {
                    System.out.println(greeter.greetedUser(commandExtractor.getName()));
                    System.out.println(greeter.greeted());

                }
                else {
                    System.out.println(greeter.greeted());
                }
            } catch (Exception ex) {
                System.out.println("invalid Command");
            }
        } else if (commandExtractor.getCommand().equals("reset")) {
            greeter.reset();

        } else if (commandExtractor.getCommand().equals("clear")) {
            greeter.remove(commandExtractor.getName());

        } else if (commandExtractor.getCommand().equals("help")) {
            greeter.help();

        } else if (commandExtractor.getCommand().equals("exit")) {
            greeter.exit();
        } else System.out.println("invalid");
        return "";
        //return execute(commandExtractor);
    }

}





