import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MericanoTest {

    @Test
    void newSenseDistrictsCase1(){
        TimBot t = new SpressoBot(42, 2);
        DohNat planet = new DohNat( 1, 1, 11, 1 );
        Mericano district = new Mericano(planet,1,1,10,1);

        district.newSenseDistricts(); //returns lowest number of rounds for plant to be ready for harvest
        assertEquals(district.newSenseDistricts(),0,"newSenseDistricts did not return correct value");
        assertEquals(district.mericanoJolts,10,"Incorrect number of Jolts");
        assertEquals(district.mericanoGrowth,1,"Incorrect number of Growth");
    }

    @Test
    void newSenseDistrictsCase2(){
        TimBot t = new SpressoBot(42, 2);
        t.startRound();
        int [] spressoSensed = {0, 10, 10, 10, 10};
        boolean [] botsSensed = {false, true, true, true, true};
        t.senseDistricts(spressoSensed, botsSensed);

        DohNat planet = new DohNat( 1, 1, 11, 1 );
        Mericano district = new Mericano(planet,1,1,10,1);

        district.newSenseDistricts(); //returns lowest number of rounds for plant to be ready for harvest
        assertEquals(district.newSenseDistricts(),0,"newSenseDistricts did not return correct value");
        assertEquals(district.mericanoJolts,10,"Incorrect number of Jolts");
        assertEquals(district.mericanoGrowth,1,"Incorrect number of Growth");
    }
}
