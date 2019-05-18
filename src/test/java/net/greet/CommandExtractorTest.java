package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandExtractorTest {

    @Test
    void shouldGetGreetCommands_1( ) {
        CommandExtractor commandExtractor = new CommandExtractor("greet YASH English");

        assertEquals("greet", commandExtractor.getCommand());
        assertEquals("YASH", commandExtractor.getName());
        assertEquals("English", commandExtractor.getLanguage());
    }

    @Test
    void shouldGetGreetCommands_2( ) {
        CommandExtractor commandExtractor = new CommandExtractor("greet YASH ");

        assertEquals("greet", commandExtractor.getCommand());
        assertEquals("YASH", commandExtractor.getName());
//        assertEquals("Tswana", commandExtractor.getLanguage());
    }

    @Test
    void shouldGetGreetCommands_3( ) {
        CommandExtractor commandExtractor = new CommandExtractor("greet YASH");

        assertEquals("greet", commandExtractor.getCommand());
        assertEquals("YASH", commandExtractor.getName());
        assertEquals(" ", commandExtractor.getLanguage());
    }

    @Test
    void shouldGetGreetedCommands_1( ) {
        CommandExtractor commandExtractor = new CommandExtractor("greeted YASH");

        assertEquals("greeted", commandExtractor.getCommand());
        assertEquals("YASH", commandExtractor.getName());
        assertEquals("", commandExtractor.getLanguage());
    }

    @Test
    void shouldGetGreetedCommands_2( ) {
        CommandExtractor commandExtractor = new CommandExtractor("greeted");

        assertEquals("greeted", commandExtractor.getCommand());
        assertEquals("", commandExtractor.getName());
        assertEquals("Tswana", commandExtractor.getLanguage());
    }

    @Test
    void shouldGetClearCommands( ) {
        CommandExtractor commandExtractor = new CommandExtractor("clear YASH");

        assertEquals("clear", commandExtractor.getCommand());
        assertEquals("YASH", commandExtractor.getName());
    }

    @Test
    void shouldGetClearCommandAndName( ) {
        CommandExtractor commandExtractor = new CommandExtractor("clear");

        assertEquals("clear", commandExtractor.getCommand());
        assertEquals(" ", commandExtractor.getName());

    }
}