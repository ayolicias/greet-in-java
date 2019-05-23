package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandExtractorTest {

    @Test
    void shouldGetGreetCommandsWithLanguage( ) {
        CommandExtractor commandExtractor = new CommandExtractor("greet Yash English");

        assertEquals("greet", commandExtractor.getCommand());
        assertEquals("Yash", commandExtractor.getName());
        assertEquals("English", commandExtractor.getLanguage());
    }

    @Test
    void shouldGetGreetCommandsWithDefaultLang( ) {
        CommandExtractor commandExtractor = new CommandExtractor("greet Yash ");

        assertEquals("greet", commandExtractor.getCommand());
        assertEquals("Yash", commandExtractor.getName());
        assertEquals("tswana", commandExtractor.getLanguage());
    }

    @Test
    void shouldGetGreetCommandsWithDefault( ) {
        CommandExtractor commandExtractor = new CommandExtractor("greet Yash TSWANA");

        assertEquals("greet", commandExtractor.getCommand());
        assertEquals("Yash", commandExtractor.getName());
        assertEquals("TSWANA", commandExtractor.getLanguage());
    }

    @Test
    void shouldGetGreetedCommandsWithCount( ) {
        CommandExtractor commandExtractor = new CommandExtractor("greeted {ziya=1}");

        assertEquals("greeted", commandExtractor.getCommand());
        assertEquals("{ziya=1}", commandExtractor.getName());
    }

    @Test
    void shouldGetClearCommands( ) {
        CommandExtractor commandExtractor = new CommandExtractor("clear Yash");

        assertEquals("clear", commandExtractor.getCommand());
        assertEquals("Yash", commandExtractor.getName());
    }

    @Test
    void shouldGetResetCommandAndName( ) {
        CommandExtractor commandExtractor = new CommandExtractor("clear");

        assertEquals("clear", commandExtractor.getCommand());

    }
}