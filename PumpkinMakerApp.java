//Karolina Krzak
//11/2/2020
//Object Oriented 
//Pumpkin Maker 
// This program will allow a user to create a tool perfect for the season: one that draws a custom
//pumpkin image on the screen. This is called Pumpkin Maker. It allows you to set the position,
//width and height, eye shape, nose shape, and mouth shape of the pumpkin you want to make. 



// Import declarations
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// Draws the panel
class DrawingPanel extends JPanel {
	// Variable declarations
	private int pumpkinWidth;
	private int pumpkinHeight;
	private int left;
	private int top;
	private String eyeType;
	private String noseType;
	private String mouthType;
	
	// Getter for pumpkinWidth
	public int getPumpkinWidth() { 
		return pumpkinWidth;
	}

	// Getter for pumpkinHeight
	public int getPumpkinHeight() { 
		return pumpkinHeight;
	}

	// Getter for left
	public int getLeft() { 
		return left;
	}

	// Getter for top
	public int getTop() { 
		return top;
	}

	// Getter for eyeType
	public String getEyeType() { 
		return eyeType;
	}

	// Getter for noseType
	public String getNoseType() { 
		return noseType;
	}

	// Getter for mouthType
	public String getMouthType() { 
		return mouthType;
	}
	
	// Setter for pumpkinWidth
	public void setPumpkinWidth(int val) {
		if (val < 0) {
			pumpkinWidth = 100;
		} else if (val > 1) {
			pumpkinWidth = val;
		}
	}

	// Setter for pumpkinHeight
	public void setPumpkinHeight(int val) {
		if (val < 0) {
			pumpkinHeight = 100;
		} else if (val > 1) {
			pumpkinHeight = val;
		}
	}

	// Setter for left
	public void setLeft(int val) {
		if (val < 0) {
			left = 100;
		} else if (val > 1) {
			left = val;
		}
	}

	// Setter for top
	public void setTop(int val) {
		if (val < 0) {
			top = 100;
		} else if (val > 1) {
			top = val;
		}
	}

	// Setter for eyeType
	public void setEyeType(String str) {
		if (str.equalsIgnoreCase("c")) {
			eyeType = "c";
		} else if (str.equalsIgnoreCase("s")) {
			eyeType = "s";
		} else if (str.equalsIgnoreCase("t")) {
			eyeType = "t";
		} else {
			JOptionPane.showMessageDialog(null, "Please enter 'C', 'S', or 'T'");
		}
	}

	// Setter for noseType
	public void setNoseType(String str) {
		if (str.equalsIgnoreCase("c")) {
			noseType = "c";
		} else if (str.equalsIgnoreCase("s")) {
			noseType = "s";
		} else if (str.equalsIgnoreCase("t")) {
			noseType = "t";
		} else {
			JOptionPane.showMessageDialog(null, "Please enter 'C', 'S', or 'T'");
		}
	}

	// Setter for mouthType
	public void setMouthType(String str) {
		if (str.equalsIgnoreCase("o")) {
			mouthType = "o";
		} else if (str.equalsIgnoreCase("r")) {
			mouthType = "r";
		} else {
			JOptionPane.showMessageDialog(null, "Please enter 'O', or 'R'");
		}
	}

	// Default constructor
	public DrawingPanel() {
		setPumpkinWidth(100);
		setPumpkinHeight(100);
		setLeft(200);
		setTop(100);
		setEyeType("C");
		setNoseType("S");
		setMouthType("O");
    }

	// Non-default constructor
    public DrawingPanel(int txtLeft, int txtTop, int txtWidth, int txtHeight, String txtEyeType, String txtNoseType, String txtMouthType) {
        setPumpkinWidth(txtWidth);
		setPumpkinHeight(txtHeight);
		setLeft(txtLeft);
		setTop(txtTop);
		setEyeType(txtEyeType);
		setNoseType(txtNoseType);
		setMouthType(txtMouthType);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.ORANGE);	// Sets pumpkin color
		g.fillOval(left, top, pumpkinWidth, pumpkinHeight);

		g.setColor(Color.WHITE);	// Sets stem, eyes, nose, and mouth color

		// Draws the stem
		g.fillRect((int)(left+pumpkinWidth*0.4375), (int)(top-pumpkinHeight*0.125), (int)(pumpkinWidth*0.125), (int)(pumpkinHeight*0.125));
		
		// Draws both eyes
		if (eyeType.equals("c")) {	// Draws circle
			g.fillOval((int)(left+pumpkinWidth*0.25), (int)(top+pumpkinHeight*0.25), (int)(pumpkinWidth*0.125), (int)(pumpkinHeight*0.125));	// Draws left eye
			g.fillOval((int)(left+pumpkinWidth*0.625), (int)(top+pumpkinHeight*0.25), (int)(pumpkinWidth*0.125), (int)(pumpkinHeight*0.125));	// Draws right eye
		} else if (eyeType.equals("s")) {	// Draws square
			g.fillRect((int)(left+pumpkinWidth*0.25), (int)(top+pumpkinHeight*0.25), (int)(pumpkinWidth*0.125), (int)(pumpkinHeight*0.125));	// Draws left eye
			g.fillRect((int)(left+pumpkinWidth*0.625), (int)(top+pumpkinHeight*0.25), (int)(pumpkinWidth*0.125), (int)(pumpkinHeight*0.125));	// Draws right eye
		} else if (eyeType.equals("t")) {	// Draws triangle
			// Creates triangle for left eye
			int leftEyeX[] = new int[] {(int)(left+pumpkinWidth*0.25), (int)(left+pumpkinWidth*0.3125), (int)(left+pumpkinWidth*0.375)};
			int leftEyeY[] = new int[] {(int)(top+pumpkinHeight*0.375), (int)(top+pumpkinHeight*0.25), (int)(top+pumpkinHeight*0.375)};
			g.fillPolygon(leftEyeX, leftEyeY, 3);

			// Creates triangle for right eye
			int rightEyeX[] = new int[] {(int)(left+pumpkinWidth*0.625), (int)(left+pumpkinWidth*0.6875), (int)(left+pumpkinWidth*0.75)};
			int rightEyeY[] = new int[] {(int)(top+pumpkinHeight*0.375), (int)(top+pumpkinHeight*0.25), (int)(top+pumpkinHeight*0.375)};
			g.fillPolygon(rightEyeX, rightEyeY, 3);
		}

		// Draws the nose
		if (noseType.equals("c")) {	// Draws circle
			g.fillOval((int)(left+pumpkinWidth*0.4375), (int)(top+pumpkinHeight*0.4375), (int)(pumpkinWidth*0.125), (int)(pumpkinHeight*0.125));
		} else if (noseType.equals("s")) {	// Draws square
			g.fillRect((int)(left+pumpkinWidth*0.4375), (int)(top+pumpkinHeight*0.4375), (int)(pumpkinWidth*0.125), (int)(pumpkinHeight*0.125));
		} else if (noseType.equals("t")) {	// Draws triangle
			// Creates triangle for nose
			int noseX[] = new int[] {(int)(left+pumpkinWidth*0.4375), (int)(left+pumpkinWidth*0.5), (int)(left+pumpkinWidth*0.5625)};
			int noseY[] = new int[] {(int)(top+pumpkinHeight*0.5625), (int)(top+pumpkinHeight*0.4375), (int)(top+pumpkinHeight*0.5625)};
			g.fillPolygon(noseX, noseY, 3);
		}

		// Draws the mouth
		if (mouthType.equals("o")) {	// Draws circle
			g.fillOval((int)(left+pumpkinWidth*0.25), (int)(top+pumpkinHeight*0.625), (int)(pumpkinWidth*0.5), (int)(pumpkinHeight*0.125));
		} else if (mouthType.equals("r")) {	// Draws square
			g.fillRect((int)(left+pumpkinWidth*0.25), (int)(top+pumpkinHeight*0.625), (int)(pumpkinWidth*0.5), (int)(pumpkinHeight*0.125));
		}		
	}
}

class PumpkinMakerFrame extends JFrame {
	public void setupLook() {
		setTitle("Pumpkin Maker");
		centerFrame(800, 480);

		// Sets container
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		// Sets drawing panel
		DrawingPanel panCenter = new DrawingPanel();
		c.add(panCenter, BorderLayout.CENTER);

		// Sets bottom panel
		JPanel panSouth = new JPanel();
		c.add(panSouth, BorderLayout.SOUTH);
		panSouth.setLayout(new FlowLayout());

		// Creates "Left" label and text box
		JLabel lblLeft = new JLabel("Left: ");
		JTextField txtLeft = new JTextField(3);
		panSouth.add(lblLeft);
		panSouth.add(txtLeft);

		// Creates "Top" label and text box
		JLabel lblTop = new JLabel("Top: ");
		JTextField txtTop = new JTextField(3);
		panSouth.add(lblTop);
		panSouth.add(txtTop);

		// Creates "Width" label and text box
		JLabel lblWidth = new JLabel("Width: ");
		JTextField txtWidth = new JTextField(3);
		panSouth.add(lblWidth);
		panSouth.add(txtWidth);
		
		// Creates "Height" label and text box
		JLabel lblHeight = new JLabel("Height: ");
		JTextField txtHeight = new JTextField(3);
		panSouth.add(lblHeight);
		panSouth.add(txtHeight);

		// Creates "EyeType" label and text box
		JLabel lblEyeType = new JLabel("Eye (C S T): ");
		JTextField txtEyeType = new JTextField(1);
		panSouth.add(lblEyeType);
		panSouth.add(txtEyeType);

		// Creates "NoseType" label and text box
		JLabel lblNoseType = new JLabel("Nose (C S T): ");
		JTextField txtNoseType = new JTextField(1);
		panSouth.add(lblNoseType);
		panSouth.add(txtNoseType);

		// Creates "MouthType" label and text box
		JLabel lblMouthType = new JLabel("Mouth (O R): ");
		JTextField txtMouthType = new JTextField(1);
		panSouth.add(lblMouthType);
		panSouth.add(txtMouthType);

		// Creates button
		JButton btnClick = new JButton("Draw");
		btnClick.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				try {
					int valLeft = Integer.parseInt(txtLeft.getText());
					int valTop = Integer.parseInt(txtTop.getText());
					int valWidth = Integer.parseInt(txtWidth.getText());
					int valHeight = Integer.parseInt(txtHeight.getText());
					
					panCenter.setLeft(valLeft);
					panCenter.setTop(valTop);
					panCenter.setPumpkinWidth(valWidth);
					panCenter.setPumpkinHeight(valHeight);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Please only enter positive numbers");
				}
				String strEyeType = txtEyeType.getText();
				String strNoseType = txtNoseType.getText();
				String strMouthType = txtMouthType.getText();
				
				panCenter.setEyeType(strEyeType);
				panCenter.setNoseType(strNoseType);
				panCenter.setMouthType(strMouthType);

				repaint();
			}
		});
		panSouth.add(btnClick);	// Adds button to bottom panel
	}

	// Centers frame to any monitor
	public void centerFrame(int width, int height) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenDims = tk.getScreenSize();
		int screenWidth = (int)screenDims.getWidth();
		int screenHeight = (int)screenDims.getHeight();
		int left = (screenWidth - width)/2;
		int top = (screenHeight - height)/2;
		setBounds(left, top, width, height);
	}
	
	// Calls setupLook function
	public PumpkinMakerFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

// Main function
public class PumpkinMakerApp {
	public static void main(String[] args) {
		PumpkinMakerFrame frm = new PumpkinMakerFrame();
		frm.setVisible(true);
	}
}
