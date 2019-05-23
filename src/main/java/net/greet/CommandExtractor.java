package net.greet;

public class CommandExtractor {
    private String name;
    private String language;
    private String command;

    public CommandExtractor( String userInput ) {
        String[] input = userInput.split(" ");
        this.command = input[0];

        if (input.length >= 2){
            this.name = input[1].substring(0, 1).toUpperCase() + input[1].substring(1).toLowerCase();
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





