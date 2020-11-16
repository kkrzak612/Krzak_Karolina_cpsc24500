// Import declarations.
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Toolkit;

public class SlotMachineFrame extends JFrame {
    // Variable declaration.
    private TilePanel pan;

	public void setupMenu() {
        // Creating menu bar.
        JMenuBar mbar = new JMenuBar();

        // Creating menu bar items.
        JMenu mnuFile = new JMenu("File");
        JMenu mnuHelp = new JMenu("Help");
        
        // Creating file menu items.
        JMenuItem miSave = new JMenuItem("Save");
        JMenuItem miLoad = new JMenuItem("Load");
        JMenuItem miPrint = new JMenuItem("Print");
        JMenuItem miRestart = new JMenuItem("Restart");
        JMenuItem miExit = new JMenuItem("Exit");
        JMenuItem miAbout = new JMenuItem("About");

        // Adding menu items.
        mbar.add(mnuFile);
        mbar.add(mnuHelp);

        // Adding file items under file category.
        mnuFile.add(miSave);
        mnuFile.add(miLoad);
        mnuFile.add(miPrint);
        mnuFile.add(miRestart);
        mnuFile.add(miExit);

        // Adding file items under help category.
        mnuHelp.add(miAbout);

        // Action listener for save.
        miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
                TileWriter tw = new TileWriter();
                
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) { 
					if (tw.write(jfc.getSelectedFile(), pan.getTiles())) {
						JOptionPane.showMessageDialog(null, "Wrote tiles to file.");
					} else {
						JOptionPane.showMessageDialog(null, "Could not write tiles to file.");
					}
				}
			}
        });

        // Action listener for load.
        miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileReader tr;
				ArrayList<Tile> tilesRead;
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tr = new TileReader();
					tilesRead = tr.read(jfc.getSelectedFile());
					if (tilesRead == null) {
						JOptionPane.showMessageDialog(null, "Could not read tiles.");
					} else {
						pan.setTiles(tilesRead);
						repaint();
					}
				}
			}
        });

        // Action listener for print.
        miPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
        });

        // Action listener for restart.
        miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
        });

        // Action listener for exit.
        miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
        });

        // Action listener for about.
        miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Author: Karolina Krzak, URL: https://github.com/kkrzak612/Krzak_Karolina_cpsc24500");    // TODO: Add in github url.
			}
        });
        
	    setJMenuBar(mbar);
    }
    
	public void setupLook() {
        setBounds(100, 100, 900, 300);  // Sets frame bounds.
        
        // Creates container for content pane.
		Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
		pan = new TilePanel(); // Creates panel.
        c.add(pan,BorderLayout.CENTER); // Adds panel to container.
        
        // Creating south panel.
		JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());

        // Creating buttons.
        JButton btnMax = new JButton("Max");
        JButton btnMid = new JButton("Mid");
        JButton btnMin = new JButton("Min");

        JLabel lblMoney = new JLabel("$");
        JTextField txtField = new JTextField(5);

        // Adding buttons to panel.
        panSouth.add(btnMax);
        panSouth.add(btnMid);
        panSouth.add(btnMin);

        panSouth.add(lblMoney); // Adding label to panel.
        panSouth.add(txtField); // Adding text field to panel.

		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu(); 
    }
    
	public SlotMachineFrame() {
		setupLook(); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
