/*
 * @Param Import declarations.
 */
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
@SuppressWarnings("unchecked")

public class TileReader {
	public ArrayList<Tile> readFromText(String fname) {
		File f = new File(fname);
		return readFromText(f);
	}
/*
 * @Param will print 
 * @Retun will not print if object is equivalent to false
 */
	public ArrayList<Tile> readFromText(File f) {
		try {
			ArrayList<Tile> result = new ArrayList<Tile>();
			Scanner fsc = new Scanner(f);
			String line;
			String[] parts;
			int color, shape;
			Tile tile;

			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();  
				if (line.length() > 0) {  
					parts = line.split(" ");
					color = Integer.parseInt(parts[0]);
					shape = Integer.parseInt(parts[1]);
					tile = new Tile(color, shape);
					result.add(tile);
				}
			}

			fsc.close();
			return result; 
		} catch (Exception ex) {
			return null;  
		}
	}

	public ArrayList<Tile> readFromBinary(String fname) {
		File f = new File(fname);
		return readFromBinary(f);
	}
	/*
	 * @Param Binary read from file
	 */

	public ArrayList<Tile> readFromBinary(File f) {
		try {
			ArrayList<Tile> tilesRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			tilesRead = (ArrayList<Tile>)ois.readObject();
			ois.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}

	public ArrayList<Tile> readFromXML(String fname) {
		File f = new File(fname);
		return readFromXML(f);
	}

	public ArrayList<Tile> readFromXML(File f) {
		try {
			ArrayList<Tile> tilesRead;
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(f)));
			tilesRead = (ArrayList<Tile>)dec.readObject();
			dec.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}

	public ArrayList<Tile> read(String fname) {
		File f = new File(fname);
		return read(f);
	}

	public ArrayList<Tile> read(File f) {
		try {
			String fname = f.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return readFromText(f);
			} else if (fname.endsWith(".BIN")) {
				return readFromBinary(f);
			} else if (fname.endsWith(".XML")) {
				return readFromXML(f);
			} else {
				return null;
			}
		} catch (Exception ex) {
			return null;
		}
	}
}


