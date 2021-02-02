import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChickenBotTest {
    ChickenBot cb = new ChickenBot(4,3);
    private final static int[] spressos = {1,2,3,4,5};
    private final static boolean[] bots = {false,true,false,true,false};

    @Test
    void getNextMoveTest() {
        /*
        Setup for ChickenBot
         */
        cb.startRound();
        cb.senseDistricts(spressos,bots);
        cb.fireCannon();
        cb.useShield();

        //check if ChickenBot has energy to move
        assertTrue(cb.energyLevel > 0, "ChickenBot has no energy to move");
        //check if there are no other TimBots in current district
        assertFalse(cb.botsSensed[0], "botSensed did not return correct value");
        //check if there is a TimBot nearby in adjacent district
        assertTrue(cb.botsSensed[1],"botSensed did not return correct value");

        int move = cb.getNextMove(); //should return 1 in this case
        assertEquals(1,move, "getNextMove() did not return correct value");

    }
}