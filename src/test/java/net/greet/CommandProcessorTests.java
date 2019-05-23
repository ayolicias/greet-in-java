package net.greet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorTests {

    @Test
    void ShouldGreetUserWithDefaultLang(){
        GreetedUser greetedUser = new JdbcGreeted();
        CommandExtractor commandExtractor= new CommandExtractor("greet ziya");
        CommandProcessor commandProcessor = new CommandProcessor(greetedUser);

        assertEquals("dumela ziya", commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldGreetWithLang(){
        GreetedUser greetedUser = new JdbcGreeted();
        CommandExtractor commandExtractor = new CommandExtractor("greet lihle english");
        CommandProcessor commandProcessor = new CommandProcessor(greetedUser);

        assertEquals("hello lihle",commandProcessor.execute(commandExtractor));
    }

    @Test
    void ShouldRemoveUser(){
        GreetedUser greetedUser = new JdbcGreeted();

        CommandExtractor commandExtractor = new CommandExtractor("clear ziya");
        CommandProcessor commandProcessor = new CommandProcessor(greetedUser);

        assertEquals("ziya has been deleted from database",commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldClearUser(){
        GreetedUser greetedUser = new JdbcGreeted();

        CommandExtractor commandExtractor = new CommandExtractor("clear");
        CommandProcessor commandProcessor = new CommandProcessor(greetedUser);

        assertEquals("All names deleted",commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldReturnGreetedUser(){
        GreetedUser greetedUser = new JdbcGreeted();
        CommandExtractor commandExtractor = new CommandExtractor("greeted lihle");
        CommandProcessor commandProcessor = new CommandProcessor(greetedUser);

        assertEquals("lihle  have been greeted: null",commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldReturnGreetedUsers(){
        GreetedUser greetedUser = new JdbcGreeted();
        CommandExtractor commandExtractor = new CommandExtractor("greeted");
        CommandProcessor commandProcessor = new CommandProcessor(greetedUser);

        assertEquals("{}",commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldReturnInvalid(){
        GreetedUser greetedUser = new JdbcGreeted();

        CommandExtractor commandExtractor = new CommandExtractor("invalid command");
        CommandProcessor commandProcessor = new CommandProcessor(greetedUser);

        assertEquals("invalid command",commandProcessor.execute(commandExtractor));
    }
}
