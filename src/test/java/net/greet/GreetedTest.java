package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetedTest {
    @BeforeEach

    @Test
    public void shouldGreetAPerson(){
        Greeted greeted = new Greeted();

        greeted.greetUser("Yamkela", "Zulu");
        assertEquals(greeted.totalGreeted(), 1);

        greeted.greetUser("Sipho", "English");
        assertEquals(greeted.totalGreeted(), 2);
    }

    @Test
    public void shouldgetCount() throws Exception {

        Greeted greeted = new Greeted();
        greeted.greetUser("Yamkela", "Zulu");
        greeted.greetUser("Yamkela", "Zulu");
        greeted.greetUser("Yamkela", "Zulu");

        greeted.greetUser("zee", "English");
        greeted.greetUser("zee", "English");

        greeted.greetUser("Aya","Isixhosa");


        assertEquals(greeted.greetMap(),"{Yamkela=3, Aya=1, zee=2}");
    }

    @Test
    public void shouldResetUser() throws Exception {
        Greeted greeted = new Greeted();
        greeted.greetUser("Aya","Isixhosa");
        greeted.reset();
        assertEquals(greeted.greeted(),"{}");
    }

    @Test
    public void shouldClearName() throws Exception {
        Greeted greeted = new Greeted();
        greeted.greetUser("zee", "English");
        greeted.greetUser("ze", "English");
        System.out.println(greeted.remove("guygi"));

        assertEquals(greeted.greeted.toString(),"{zee=1, ze=1}");

    }

}