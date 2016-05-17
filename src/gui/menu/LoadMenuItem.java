package gui.menu;

import gui.StatusLabel;
import gui.XL;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {
 
    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");
    }

    protected void action(String path) throws FileNotFoundException {
        System.out.println(path);
    }

    protected int openDialog(JFileChooser fileChooser) {
    	System.out.println(1);
        return fileChooser.showOpenDialog(xl);
    }
}