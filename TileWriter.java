/*
 * @Param Import declarations.
 */
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;

/* @Paramj will delcare tiles
 * @Return ability to write
 */
public class TileWriter {
	public boolean writeToText(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToText(f,tiles);   
	}
/*
 * @Param will print 
 * @Return will not if false
 */
	public boolean writeToText(File f, ArrayList<Tile> tiles) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (Tile tile:tiles) {
				pw.println(tile); 
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/*
	 * @Param Will write to binary 
	 */
	public boolean writeToBinary(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToBinary(f,tiles);
	}
	
	/*
 	* @Param will file output 
 	* @Retun if true or false
 	*/	
	public boolean writeToBinary(File f, ArrayList<Tile> tiles) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(tiles);
			oos.close();
			return true; 
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean writeToXML(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToXML(f, tiles);
	}
	
	/*
 	* @Param will encode files
 	*/
	public boolean writeToXML(File f, ArrayList<Tile> tiles) {
		try {
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(f)));
			enc.writeObject(tiles);
			enc.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean write(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return write(f, tiles);
	}

	/*
 	* @Param will write out files and texts 
	 * @Retun if not false if false will not return files
 	*/
	
	public boolean write(File f, ArrayList<Tile> tiles) {
		try {
			String fname = f.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return writeToText(f, tiles);
			} else if (fname.endsWith(".BIN")) {
				return writeToBinary(f, tiles);
			} else if (fname.endsWith(".XML")) {
				return writeToXML(f, tiles);
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}
}

