package net.greet;

import java.sql.SQLException;

public class CommandProcessor {

    Greet greeter;

    private String language;
    private String name;

    public String execute(CommandExtractor commandExtractor) throws SQLException {

        if ("greet".equals(commandExtractor.getName())) {
            if (language == "TSWANA")
                Languages.valueOf(language).getGreets(name);

            System.out.println(Languages.valueOf(language).getGreets(name));
            greeter.equals(name);
        }
        else if (language == ""){
             System.out.println(Languages.valueOf(language).getGreets(name));

        }

        return execute(commandExtractor);
    }
}


