package net.greet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorTests {

    @Test
    void ShouldGreetUserWithDefaultLang(){
        CommandExtractor commandExtractor= new CommandExtractor("greet ziya");
        CommandProcessor commandProcessor = new CommandProcessor();

        assertEquals("dumela ziya", commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldGreetWithLang(){
        CommandExtractor commandExtractor = new CommandExtractor("greet lihle english");
        CommandProcessor commandProcessor = new CommandProcessor();

        assertEquals("hello lihle",commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldCountGreetedUsers(){
        CommandExtractor commandExtractor = new CommandExtractor("count");
        CommandProcessor commandProcessor = new CommandProcessor();

        assertEquals("2",commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldRemoveUser(){
        CommandExtractor commandExtractor = new CommandExtractor("clear ziya");
        CommandProcessor commandProcessor = new CommandProcessor();

        assertEquals("ziya has been deleted from database",commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldClearUser(){
        CommandExtractor commandExtractor = new CommandExtractor("clear");
        CommandProcessor commandProcessor = new CommandProcessor();

        assertEquals("All names deleted",commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldReturnGreetedUser(){
        CommandExtractor commandExtractor = new CommandExtractor("greeted lihle");
        CommandProcessor commandProcessor = new CommandProcessor();

        assertEquals("lihle  have been greeted: 1",commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldReturnGreetedUsers(){
        CommandExtractor commandExtractor = new CommandExtractor("greeted");
        CommandProcessor commandProcessor = new CommandProcessor();

        assertEquals("{yash=1, lihle=1}",commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldReturnInvalid(){
        CommandExtractor commandExtractor = new CommandExtractor("invalid command");
        CommandProcessor commandProcessor = new CommandProcessor();

        assertEquals("invalid command",commandProcessor.execute(commandExtractor));
    }
    @Test
    void ShouldExitApp(){
        CommandExtractor commandExtractor = new CommandExtractor("exit");
        CommandProcessor commandProcessor = new CommandProcessor();

        assertEquals("exit",commandProcessor.execute(commandExtractor));

    }
}
