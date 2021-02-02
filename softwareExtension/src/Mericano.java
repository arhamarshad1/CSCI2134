public class Mericano extends District{

    /**
     * This constructor initializes the district, its spresso plant counter, and
     * saves planet, its coordinates, which it will need to query adjoining
     * districts.
     * <p>
     * parameters: planet: reference to DohNat so that adjacent districts can be
     * accessed.
     * x : x coordinate of the district
     * y : y coordinate of the district
     * jolts : number of jolts that the TimBot gets from a harvest.
     * growth : amount of time it takes to grow spresso
     *
     * @param planet
     * @param x
     * @param y
     * @param jolts
     * @param growth
     */
    public Mericano(DohNat planet, int x, int y, int jolts, int growth) {
        super(planet, x, y, jolts, growth);
    }

    public int newSenseDistricts(){
        int [] spresso = new int[5];
        boolean [] bots = new boolean[5];
        doSensePhase(); //sense all districts

        int min = spresso[0];
        //find the minimum time to harvest spresso plant
        for (int i=1;i<spresso.length;i++){
            if(min < spresso[i]){
                min = spresso[i];
            }
        }
        return min;
    }
}
