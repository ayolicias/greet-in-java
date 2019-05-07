package net.greet;

import org.h2.command.Command;

public class commandProcessor{
    public String Name;
    public String Language;
    public final Command command;

    public commandProcessor( Command command){
        this.command = command;
    }


    public void greetUser( String userName, String language ) {

    }
}
