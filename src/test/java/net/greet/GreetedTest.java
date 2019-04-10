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

        assertEquals(greeted.greeted().toString(),"{Yamkela=3}");

    }

//    @Test
//    public void shouldclearuser(){
//
//        Greeted greeted = new Greeted();
//
//        Greeted.greetUser("zee", "Isixhosa");
//        assertEquals(greeted.reset().to,"{zee=1}");
//
//
//    }

}