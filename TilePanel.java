/*
 * @Param Import declarations.
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

class TilePanel extends JPanel implements MouseListener, MouseMotionListener  {
	/*
	 * @Param Variable declarations.
	 */
	private ArrayList<Tile> tiles;
	private String mouseStatus;
	
	public ArrayList<Tile> getTiles() {
		return tiles; 
	}

	public void setTiles(ArrayList<Tile> tiles ) {
		this.tiles = tiles; 
	}

	public TilePanel() {
		tiles = new ArrayList<Tile>();
		addMouseListener(this);
		addMouseMotionListener(this);

		tiles.add(new Tile());
		tiles.add(new Tile());
		tiles.add(new Tile());
		tiles.add(new Tile());

		mouseStatus = "Welcome";
	}

	@Override 
	public void paintComponent(Graphics g) {
		/*
		 * @Param Variable declarations.
		 */
		int x = 30;

		super.paintComponent(g);

		for (Tile tile : tiles) {
			/*
			 * @Param Sets colors.
			 */
			if (tile.getColor() == 0) {
				g.setColor(Color.GREEN);
			} else if (tile.getColor() == 1) {
				g.setColor(Color.YELLOW);
			} else if (tile.getColor() == 2) {
				g.setColor(Color.BLUE);
			} else if (tile.getColor() == 3) {
				g.setColor(Color.RED);
			} else if (tile.getColor() == 4) {
				g.setColor(Color.ORANGE);
			}

			/*
			 * @Param Sets shape.
			 */
			if (tile.getShape() ==  0) {
				g.fillOval(x, 30, 150 , 150);
				x = (x + 230);
			} else if (tile.getShape() ==  1) {
				g.fillRect(x, 30, 150 , 150);
				x = (x + 230);
			}
		}
	}

	public String getMouseStatus() {
		return mouseStatus;
	}

	public void setMouseStatus(String ms) {
		mouseStatus = ms;
	}

	public void mouseEntered(MouseEvent e) { 
		mouseStatus = "Entered the window.";
		repaint();
	}

	public void mouseExited(MouseEvent e) {
		mouseStatus = "Exited the window.";
		repaint();
	}

	public void mousePressed(MouseEvent e) {
		mouseStatus = String.format("Mouse pressed at (%d, %d)", e.getX(), e.getY());
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		mouseStatus = String.format("Mouse released at (%d, %d)", e.getX(), e.getY());
		repaint();
	}

	public void mouseMoved(MouseEvent e) { 
		mouseStatus = String.format("Mouse moved at (%d, %d)", e.getX(), e.getY());
		repaint();
		
	}

	public void mouseDragged(MouseEvent e) { 
		mouseStatus = String.format("Mouse dragged at (%d, %d)", e.getX(), e.getY());
		repaint();
	}

	public void mouseClicked(MouseEvent e) {
		mouseStatus = String.format("Mouse clicked at (%d, %d)", e.getX(), e.getY());

		/*
		 * @Param Tile 1.
		 */
		if ((e.getX() >= 30 && e.getX() <= 180) && (e.getY() >= 30 && e.getY() <= 180)) {
			tiles.get(0).setRandom();
		}

		/*
		 * @Param Tiles 2.
		 */
		if ((e.getX() >= 260 && e.getX() <= 410) && (e.getY() >= 30 && e.getY() <= 180)) {
			tiles.get(1).setRandom();
		}

		/*
		 * @Param Tiles 3.
		 */
		if ((e.getX() >= 490 && e.getX() <= 640) && (e.getY() >= 30 && e.getY() <= 180)) {
			tiles.get(2).setRandom();
		}

		/*
		 * @Param Tiles 4.
		 */
		if ((e.getX() >= 720 && e.getX() <= 870) && (e.getY() >= 30 && e.getY() <= 180)) {
			tiles.get(3).setRandom();
		}

		repaint();
	}
}
