package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetedTest {
    @BeforeEach

    @Test
    public void shouldGreetAPerson(){
        Greeted greeted = new Greeted();

        assertEquals("hello Yamkela", greeted.greetUser("Yamkela","english"));

    }

    @Test
    public void shouldgetCount() throws Exception {

        Greeted greeted = new Greeted();
        greeted.greetUser("Yamkela", "english");
        greeted.greetUser("Yamkela", "english");
        greeted.greetUser("Yamkela", "tswana");

        greeted.greetUser("zee", "english");
        greeted.greetUser("zee", "english");

        greeted.greetUser("Aya","isixhosa");


        assertEquals(greeted.greeted(),"{Yamkela=3, Aya=1, zee=2}");
    }

    @Test
    public void shouldResetUser() throws Exception {
        Greeted greeted = new Greeted();
        greeted.greetUser("Aya","isixhosa");
        greeted.reset();
        assertEquals(greeted.greeted(),"{}");
    }

    @Test
    public void shouldClearName() throws Exception {
        Greeted greeted = new Greeted();
        greeted.greetUser("zee", "english");
        greeted.greetUser("ze", "english");
        System.out.println(greeted.remove("guygi"));

        assertEquals(greeted.greeted(),"{zee=1, ze=1}");
    }

}