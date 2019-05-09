package net.greet;

public class CommandExtractor {
    private String name;
    private String language;
    private String command;

    //String[]input;
    public CommandExtractor(String command, String name, String language){
        this.name = name;
        this.language = language;

        String[]input = command.split(" ");
        this.command = input[0];
        this.command = input[1];
        this.command = input[2];
    }
//public String getCommand(){
//    return command;
//}

    public String getName() {
        return name;
    }


    public String getLanguage() {
        return language;
    }

    public String getcommand() {

        return command();
    }

    public String command() {
        return command;
    }

    public String getGreet() {

        return "getName(), getLanguage()";
    }
}










