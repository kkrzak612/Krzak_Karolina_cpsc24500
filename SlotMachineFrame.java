/*
 * @Param Import declarations.
 */
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
import java.text.DecimalFormat;
import javax.swing.SwingUtilities;

public class SlotMachineFrame extends JFrame {
    
	/*
	 * @Param Variable declaration.
	 */
    private TilePanel pan;
    private TileRandomizer rdm;
    private TileChecker ch;
    double money = 5.00; 
    
        JButton btnMax = new JButton("Max");
        JButton btnMid = new JButton("Mid");
        JButton btnMin = new JButton("Min");
        JTextField txtField = new JTextField("5.00",5);
    public double getMoney(){
        return money;
    }
	public void setupMenu() {
        /*
         * @Param Creating menu bar.
         */
        JMenuBar mbar = new JMenuBar();

        /*
         * @Param Creating menu bar items.
         */
        JMenu mnuFile = new JMenu("File");
        JMenu mnuHelp = new JMenu("Help");
        
        /*
         * @Param Creating file menu items.
         */
        JMenuItem miSave = new JMenuItem("Save");
        JMenuItem miLoad = new JMenuItem("Load");
        JMenuItem miPrint = new JMenuItem("Print");
        JMenuItem miRestart = new JMenuItem("Restart");
        JMenuItem miExit = new JMenuItem("Exit");
        JMenuItem miAbout = new JMenuItem("About");

        /*
         * @Param Adding menu items.
         */
        mbar.add(mnuFile);
        mbar.add(mnuHelp);

        /*
         * @Param Adding file items under file category.
         */
        mnuFile.add(miSave);
        mnuFile.add(miLoad);
        mnuFile.add(miPrint);
        mnuFile.add(miRestart);
        mnuFile.add(miExit);

        /*
         * @Param Adding file items under help category.
         */
        mnuHelp.add(miAbout);

        /*
         * @Param Action listener for save.
         */
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

        /*
         * @Param Action listener for load.
         */
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

        /*
         * @Param Action listener for print.
         */
        miPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
        });

        /*
         * @Param Action listener for restart.
         */
        miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            restart();
			}
        });

        /*
         * @Param Action listener for exit.
         */
        miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
        });

        /* 
         * @Param Action listener for about.
         */
        miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Author: Karolina Krzak, URL: urlLinkStuff");    // TODO: Add in github url.
			}
        });
        
	    setJMenuBar(mbar);
    }
    /*
     * @Param Sets frame bounds
     */
	public void setupLook() {
        setBounds(100, 100, 900, 300);  
        
        /*
         * @Param  Creates container for content pane.
         */
		Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        /*
         * @Param Creates panel
         */
		pan = new TilePanel(); 
		
		/*
		 * @Param adds panel to container
		 */
        c.add(pan,BorderLayout.CENTER); 
        
        /*
         * @Param Creating south panel.
         */
		JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        
        rdm = new TileRandomizer(pan);
        ch = new TileChecker(pan);
        
        /*
         * @Param Creating buttons.
         */
        
        btnMax.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdm.randomize();
                repaint();
                    if(ch.checkBoth()==true){  
                                money*=100;
                                String s = String.format("%.2f", money);
                                txtField.setText(s);
                    }
                    else if(ch.check()==true){  
                                money*=25;
                                String s = String.format("%.2f", money);
                                txtField.setText(s);    
                    }
                    else{
                        money=0;
                        String s = String.format("%.2f", money);
                        txtField.setText(s);
                        btnMax.setEnabled(false);
                        btnMin.setEnabled(false);
                        btnMid.setEnabled(false);
                    }
                
            
            }
        });
      /*
       * @Param sets up bid 
       */
        
        btnMid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdm.randomize();
                    if(ch.checkBoth()==true){  
                                money*=50;
                                String s = String.format("%.2f", money);
                                txtField.setText(s);
                    }
                    else if(ch.check()==true){  
                                money*=10;
                                String s = String.format("%.2f", money);
                                txtField.setText(s);    
                    }
                    else{
                        money/=2;
                        String s = String.format("%.2f", money);
                        txtField.setText(s);
                    }
                if(money<0.005){
                    btnMax.setEnabled(false);
                    btnMin.setEnabled(false);
                    btnMid.setEnabled(false);
                }
            repaint();
            }
        });
        
        /*
         * @Param sets up bid for user and listener from user 
         */
        
        btnMin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdm.randomize();
                repaint();
                
                    if(ch.checkBoth()==true){  
                                money*=10;
                                String s = String.format("%.2f", money);
                                txtField.setText(s);
                    }
                    else if(ch.check()==true){  
                                money*=5;
                                String s = String.format("%.2f", money);
                                txtField.setText(s);    
                    }
                    else{
                        money=money-money/10;
                        String s = String.format("%.2f", money);
                        txtField.setText(s);
                    }
                if(money<0.005){
                    btnMax.setEnabled(false);
                    btnMin.setEnabled(false);
                    btnMid.setEnabled(false);
                }
            }
        });
        JLabel lblMoney = new JLabel("$");
        

        /*
         * @Param Adding buttons to panel.
         */
        
        panSouth.add(btnMax);
        panSouth.add(btnMid);
        panSouth.add(btnMin);

        /*
         * @Param adding label to panel
         * @Param adding text field to panel
         */
        panSouth.add(lblMoney);
        panSouth.add(txtField); 

		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu(); 
    }
        public void restart(){
            btnMax.setEnabled(true);
            btnMin.setEnabled(true);
            btnMid.setEnabled(true);
            money=5;
            String s = String.format("%.2f", money);
            txtField.setText(s);
        }
    
	public SlotMachineFrame() {
            setupLook();
            rdm.randomize();
            setDefaultCloseOperation(EXIT_ON_CLOSE);
                
	}
}

