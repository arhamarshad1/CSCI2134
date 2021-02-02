import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BullyBotTest {
    BullyBot bb = new BullyBot(4,6);
    private final static int[] spressos = {5,1,0,3,4};
    private final static boolean[] bots = {false,true,false,true,false};

    @Test
    void fireCannonTest() {
        /*
        Setup to initiate BullyBot
         */
        bb.startRound();
        bb.senseDistricts(spressos,bots);
        //check if arrays are not null
        assertNotNull(bb.spressoSensed,"SenseDistricts did not return correct values");
        assertNotNull(bb.botsSensed,"SenseDistricts did not return correct values");

        assertTrue(bb.energyLevel >= 3, "BullyBot does not have enough energy to fire");

        //in this case the BullyBot should fire as there is a Timbot in the North and South District
        int [] shots = bb.fireCannon(); //should return {District.North,District.SOUTH}
        assertNotNull(shots, "fireCannon() did not return correct value");
        assertArrayEquals(new int[]{1, 3},shots, "fireCannon() did not return correct value");
    }
}