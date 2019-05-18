package net.greet;

public class CommandExtractor {
    private String name;
    private String language;
    private String command;

    public CommandExtractor( String userInput ) {
        String[] input = userInput.split(" ");

        if (input.length == 3) {
            this.command = input[0];
            this.name = input[1];
            this.language = input[2];
        }
        if (input.length == 2) {
            this.command = input[0];
            this.name = input[1];

        }
        if (input.length == 1) {
            this.command = input[0];
        }

    }
    public String getName() {
        return this.name;
    }


    public String getLanguage() {
        return this.language;
    }

    public String getCommand() {
        return this.command;
    }
}





