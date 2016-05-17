package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.Slot;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import util.XLBufferedReader;
import util.XLException;

class LoadMenuItem extends OpenMenuItem {

	public LoadMenuItem(XL xl, StatusLabel statusLabel) {
		super(xl, statusLabel, "Load");
	}

	protected void action(String path) throws FileNotFoundException {
		XLBufferedReader b = null;
		HashMap<String, Slot> map = new HashMap<String, Slot>();

		try {
			b = new XLBufferedReader(path);
		} catch (FileNotFoundException e) {
			statusLabel.setText(e.getMessage());
		}

		try {
			Set<Map.Entry<String, Slot>> set = xl.getAllEntries();
			for (Map.Entry<String, Slot> entry : set) {
				map.put(entry.getKey(), entry.getValue());
			}
			b.load(map);
		} catch (XLException e) {
			statusLabel.setText("Could not load file " + e.getMessage());
		}
		xl.setMap(map);

	}

	protected int openDialog(JFileChooser fileChooser) {
		System.out.println(1);
		return fileChooser.showOpenDialog(xl);
	}
}