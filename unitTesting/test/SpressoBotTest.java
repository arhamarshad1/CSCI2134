import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpressoBotTest {
    SpressoBot sb = new SpressoBot(4,3);
    private final static int[] spressos = {5,1,0,3,4};
    private final static boolean[] bots = {false,true,false,true,false};

    @Test
    void getNextMoveTest() {
        /*
        Setup for SpressoBot
         */
        sb.startRound();
        sb.senseDistricts(spressos,bots);
        sb.fireCannon();
        sb.useShield();

        assertTrue(sb.energyLevel > 0, "SpressoBot has no energy to move");
        //check if there is spressoPlant nearby to harvest
        assertEquals(0,sb.spressoSensed[2], "spressoSensed returns wrong value");
        //check if there are no TimBots in near district
        assertFalse(sb.botsSensed[0], "botSensed did not return correct value");

        int move = sb.getNextMove(); //should move to District.EAST because thats where a plant is ready to be harvested
        assertEquals(2,move,"getNextMove() did not return correct value");
        assertNull(sb.fireCannon(),"SpressoBot will never fire its cannon");
    }
}