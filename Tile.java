/*
 * @Param Import declarations.
 */
import java.io.Serializable;
import java.util.Random;

public class Tile implements Serializable {
	/*
	 * @Param Variable declarations.
	 */
	private int shape; 
	private int color;

	/*
	 * @Param Getter for shape.
	 */
	
	public int getShape() {
		return shape;
	}

	/*
	 * @Param Getter for color.
	 */
	public int getColor() {
		return color;
	}

	/*
	 * @Param Setter for shape.
	 */
	public void setShape(int x) {
		shape = x;  
	}

	/*
	 * @Param Setter for color.
	 */
	public void setColor(int y) {
		color = y;
	}

	public void setRandom() {
		Random rand = new Random();

		/*
		 * @Param Variable declarations.
		 */
		color = rand.nextInt(5);
		shape = rand.nextInt(2);
	}


	/*
	 * @Param Non-default constructor.
	 */
    public Tile(int color, int shape) {
		setColor(color);
		setShape(shape);
	}
    
    /*
     * @Param will reutrn string of tile
     */

	@Override
	public String toString() {
		return String.format("%s %s", color, shape);	
	}
         @Override
    public boolean equals(Object obj){    
    if(this == obj) 
            return true; 
          
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false;  
        
        Tile tile = (Tile) obj; 
           
        return (tile.shape == this.shape && tile.color == this.color); 
    } 

    public boolean equalsColor(Object obj){    
        if(this == obj) 
            return true; 
          
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false;  
        
        Tile tile = (Tile) obj; 
           
        return (tile.color == this.color); 
    }
}