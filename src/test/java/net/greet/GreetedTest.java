package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetedTest {

    @Test
    public void shouldGreetAPerson(){
        Greeted greeted = new Greeted();

        greeted.greetUser("Yamkela", "Zulu");
        assertEquals(greeted.totalGreeted(), 1);

        greeted.greetUser("Sipho", "English");
        assertEquals(greeted.totalGreeted(), 2);
    }

    @Test
    public void shouldgetCount(){

        Greeted greeted = new Greeted();
        greeted.greetUser("Yamkela", "Zulu");
        greeted.greetUser("Yamkela", "Zulu");
        greeted.greetUser("Yamkela", "Zulu");

        greeted.greetUser("zee", "English");
        greeted.greetUser("zee", "English");

        greeted.greetUser("Aya","Isixhosa");

        assertEquals(greeted.greeted().toString(),"{Yamkela=3, Aya=1, zee=2}");
    }

    @Test
    public void shouldResetUser(){
        Greeted greeted = new Greeted();
        greeted.greetUser("Aya","Isixhosa");
        greeted.reset();
        assertEquals(greeted.greeted().toString(),"{}");

    }

    @Test
    public void shouldClear(){
        Greeted greeted = new Greeted();
        greeted.greetUser("zee", "English");
        greeted.remove("zee");

        assertEquals(greeted.greeted().toString(),"{}");

    }

}