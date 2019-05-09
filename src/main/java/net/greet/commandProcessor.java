package net.greet;

import java.sql.SQLException;

public class CommandProcessor {

    Greet greeter;

    public CommandProcessor(Greet greet) {
        this.greeter = greet;
    }

    public String execute(CommandExtractor commandExtractor) throws SQLException {

        if ("greet".equalsIgnoreCase(commandExtractor.command())) {

            greeter.name(commandExtractor.getName());

            System.out.printf(commandExtractor.getGreet());
            return commandExtractor.getGreet();
        }
        return null;
    }
}

}
