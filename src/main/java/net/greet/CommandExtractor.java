package net.greet;

public class CommandExtractor {
//    public String getLanguage;
    private String name;
    private String language;
    private String command;

    //String[]input;
    public CommandExtractor(String command) {
        String[] input = command.split(" ");
        this.command = input[0];
        this.name = input[1];
        this.language = input[2];

        Greet greeter;


//        if (command[0].equals("greet")) {

            if (name == name) {
                Languages.valueOf(language).getGreets(language);

                System.out.println(Languages.valueOf(language).getGreets(name));
//                greeter.equals() language);
            }
        }

        public String getName () {
            return name;
        }


        public String getLanguage () {
            return language;
        }

        public String getCommand () {

            return command;
        }

    }












