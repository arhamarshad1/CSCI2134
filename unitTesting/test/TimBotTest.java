import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TimBotTest {
    //sample values for test case
    TimBot timBot = new TimBot(1,2);
    private final static int[] spressos = {1,2,3,4,5};
    private final static boolean[] bots = {true,false,true,false,true};

    @Test
    void getIDTest() {
        assertEquals(1, timBot.getID(), "getID did not return correct values");
    }

    @Test
    void startRoundTest() {
        assertTrue(timBot.energyLevel >= 0, "startRound did not return correct value");
    }

    @Test
    void senseDistrictsTest() {
        //check if arrays are not null before sensing district
        assertNotNull(spressos, "Array must not be null in order to senseDistricts");
        assertNotNull(bots, "Array must not be null in order to senseDistricts");

        //initiate TimBot
        timBot.startRound();
        timBot.senseDistricts(spressos,bots);
        assertEquals(5,timBot.spressoSensed.length,"senseDistricts did not return correct arrays");
        assertEquals(5,timBot.botsSensed.length,"senseDistricts did not return correct arrays");

        //arrays must be same after senseDistricts is called
        assertArrayEquals(timBot.spressoSensed,spressos, "senseDistricts() did not copy arrays properly");
        assertArrayEquals(timBot.botsSensed,bots,"senseDistricts() did not copy arrays properly");
    }

    @Test
    void getNextMoveTest() {
        assertEquals(0,timBot.getNextMove(), "getNextMove() did not return correct value");
    }

    @Test
    void isFunctionalTest() {
        assertTrue(timBot.energyLevel >=0 , "isFunctional() did not return correct value");
    }

    @Test
    void useShieldTest() {
        /*
        Setup for TimBot
         */
        timBot.startRound();
        timBot.senseDistricts(spressos,bots);
        timBot.fireCannon();

        assertTrue(timBot.energyLevel >=0, "TimBot is not functional");
        //timbot will not raise shield because energylevel becomes -1 and it becomes nonfunctional
        assertFalse(timBot.useShield(), "useShield() returned true for energylevel = -1");
    }

    @Test
    void harvestSpressoTest() {
        timBot.harvestSpresso(50);
        assertTrue(timBot.energyLevel < 99,"Energy Level can not be greater than 99");
        assertEquals(99,timBot.energyLevel,"harvestSpresso() did not add jolts correctly");
    }

    @Test
    void fireCannonTest() {
        timBot.startRound();
        timBot.senseDistricts(spressos,bots);
        assertNull(timBot.fireCannon(), "The TimBot will never shoot");
    }

    @Test
    void testToStringTest() {
        String expected = "(N  1  2)";
        assertEquals(expected,timBot.toString(), "toString() did not return correct value");
    }
}