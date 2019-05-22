package net.greet;

public class CommandExtractor {
    private String name;
    private String language;
    private String command;

    public CommandExtractor( String userInput ) {
        String[] input = userInput.split(" ");
        this.command = input[0];

        if (input.length >= 2) {
            this.name = input[1];
        }
        else {
            this.name = "";
        }
        if (input.length >= 3) {
            this.language = input[2];

        }
        else {
            this.language = "tswana";

        }
//        if (input.length == 1) {
//            this.command = input[0];
//        }
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





