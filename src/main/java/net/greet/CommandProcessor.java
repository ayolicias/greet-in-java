package net.greet;

import java.sql.SQLException;

public class CommandProcessor {
    GreetedUser greetedUser;
    JdbcGreeted greeter = new JdbcGreeted();

    public CommandProcessor(GreetedUser greetedUser){
        this.greetedUser = greetedUser;
    }


    public String execute( CommandExtractor commandExtractor ){
        if (commandExtractor.getCommand().equals("greet")) {
            return greeter.greetUser(commandExtractor.getName(), commandExtractor.getLanguage());

        }
        else if (commandExtractor.getCommand().equals("greeted")) {
            if (commandExtractor.getName().equals("")) {
                return greeter.greeted();
            }
            else{
                return greeter.greetedUser(commandExtractor.getName());
            }

        } else if (commandExtractor.getCommand().equals("clear")) {
            if (commandExtractor.getName().equals("")) {
                return greeter.reset();
            }
            else {
                return greeter.remove(commandExtractor.getName());
            }

        } else if (commandExtractor.getCommand().equals("help")) {
           return greeter.help();

        }
        else if (commandExtractor.getCommand().equals("count")){
            return greeter.totalGreeted();
        }
        else if (commandExtractor.getCommand().equals("exit")) {
           return greeter.exit();
        } else return ("invalid command");

    }

}





