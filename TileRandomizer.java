/*
 * @Param Will set tiles at a random arrangement 
 */
public class TileRandomizer {
    private TilePanel pan;
    
    public void randomize(){
        pan.getTiles().get(0).setRandom();
        pan.getTiles().get(1).setRandom();
        pan.getTiles().get(2).setRandom();
        pan.getTiles().get(3).setRandom();
    }
    
    public TileRandomizer(TilePanel pan){
        this.pan = pan;
    }
}
