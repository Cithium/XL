package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.Slot;
import util.XLPrintStream;

import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.JFileChooser;
	
class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    protected void action(String path) throws FileNotFoundException {
        // TODO
    	XLPrintStream printStream = new XLPrintStream(path + ".xl");
    	printStream.save(xl.getAllEntries());
    	printStream.close();
    	
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}