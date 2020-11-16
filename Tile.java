// Import declarations.
import java.io.Serializable;
import java.util.Random;

public class Tile implements Serializable {
	// Variable declarations.
	private int shape; 
	private int color;

	// Getter for shape.
	public int getShape() {
		return shape;
	}

	// Getter for color.
	public int getColor() {
		return color;
	}

	// Setter for shape.
	public void setShape(int x) {
		shape = x;  
	}

	// Setter for color.
	public void setColor(int y) {
		color = y;
	}

	public void setRandom() {
		Random rand = new Random();

		// Variable declarations.
		color = rand.nextInt(5);
		shape = rand.nextInt(2);
	}

	// Default constructor.
	public Tile() {
		color = 0;
		shape = 0;
    }

	// Non-default constructor.
    public Tile(int color, int shape) {
		setColor(color);
		setShape(shape);
	}

	@Override
	public String toString() {
		return String.format("%s %s", color, shape);	// Returns string of tile.
	}
}
