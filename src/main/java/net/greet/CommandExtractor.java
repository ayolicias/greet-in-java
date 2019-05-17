package net.greet;

public class CommandExtractor {
//    public String getLanguage;
    private String name;
    private String language;
    private String command;

    public CommandExtractor(String command) {
        String[] input = command.split(" ");
        this.command = input[0];
        this.name = input[1];
        this.language = input[2];

        if (language == "Tswana") {
            Languages.valueOf(language).getGreets(language);

            System.out.println(Languages.valueOf(language).getGreets(input[1]));

        }
        else if (input[0].equals("greeted")) ;

        if (name.isEmpty()) {
            Languages.valueOf(name).getGreets(language);

            System.out.println(Languages.valueOf(name).getGreets(language));
        } else if (input[0].equals("greeted")) {

            if (name == "YASH") {
                System.out.println(Languages.valueOf(name).getGreets(language));
            }
            else if (input[0].equals("greeted")) {
            }

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












