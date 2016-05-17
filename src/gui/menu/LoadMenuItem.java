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

class LoadMenuItem extends OpenMenuItem {

	public LoadMenuItem(XL xl, StatusLabel statusLabel) {
		super(xl, statusLabel, "Load");
	}

	protected void action(String path) throws FileNotFoundException {
		XLBufferedReader b = null;
		Map<String, Slot> map = new HashMap<String, Slot>();

		try {
			b = new XLBufferedReader(path);
			System.out.println("wow");
		} catch (FileNotFoundException e) {
			statusLabel.setText(e.getMessage());
		}

	}

	protected int openDialog(JFileChooser fileChooser) {
		System.out.println(1);
		return fileChooser.showOpenDialog(xl);
	}
}