
/*
 * @Param will check users tiles 
 * @Param will detect winning combinations 
 */
public class TileChecker {
    private TilePanel pan;
    
    public boolean checkBoth(){
        if(pan.getTiles().get(0).equals(pan.getTiles().get(1))&& 
                pan.getTiles().get(1).equals(pan.getTiles().get(2)) && 
                    pan.getTiles().get(2).equals(pan.getTiles().get(3)))
            return true;
        return false;
    }
    public boolean check(){
        if(pan.getTiles().get(0).equalsColor(pan.getTiles().get(1))&& 
                pan.getTiles().get(1).equalsColor(pan.getTiles().get(2)) && 
                    pan.getTiles().get(2).equalsColor(pan.getTiles().get(3)))
            return true;
        return false;
    }
    public TileChecker(TilePanel pan){
        this.pan = pan;
    }
}
