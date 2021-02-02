import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AngryBotTest {
    AngryBot ab = new AngryBot(4,3);
    private final static int[] spressos = {5,1,0,3,4};
    private final static boolean[] bots = {false,true,false,true,false};

    @Test
    void getNextMoveTest() {
        /*
        Setup for AngryBot
         */
        ab.startRound();
        ab.senseDistricts(spressos,bots);
        ab.fireCannon();
        ab.useShield();

        //check if array is not null
        assertNotNull(ab.spressoSensed);
        assertNotNull(ab.botsSensed);

        //check if a TimBot is nearby to attack
        assertTrue(ab.botsSensed[1], "There is no Timbot nearby to attack");

        //check if there are Spresso plants ready to be harvested nearby
        assertEquals(0,ab.spressoSensed[District.EAST],"SpressoSensed did not return correct value");

        //check if the method returns correct values
        assertEquals(2,ab.getNextMove(),"getNextMove() did not return correct value");

        //check if AngryBot has enough energy to move
        assertTrue(ab.energyLevel >= 3, "AngryBot requires energylevel of 3 or more to move");
    }
}