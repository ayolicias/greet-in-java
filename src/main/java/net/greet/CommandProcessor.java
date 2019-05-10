package net.greet;

import java.sql.SQLException;

public class CommandProcessor {

    Greet greeter;

    private String language;
    private String name;

    public CommandProcessor( Greet greet) {
        this.greeter = greet;
    }

    public String execute(CommandExtractor commandExtractor) throws SQLException {

        if ("greet".equals(commandExtractor.getName())) {
            if (language == "TSWANA")
                Languages.valueOf(language).getGreets(name);

            System.out.println(Languages.valueOf(language).getGreets(name));
            greeter.equals(name);
        }
//        //default language
//        if ("greet".equals(commandExtractor.getName())) {
//            if (language = "TSWANA"){
//                Languages.valueOf(language).getGreets(command[1]);
//
//                System.out.println(Languages.valueOf(language).getGreets(command[1]));
//                greeter.greetUser(command[1], language);
//            }
//
//        }
//
        return execute(commandExtractor);
    }
}


