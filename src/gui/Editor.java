package gui;

import java.awt.Color;
import javax.swing.JTextField;

import model.Sheet;

public class Editor extends JTextField {
    private Sheet sheet;
	private CurrentSlot currentSlot;

	public Editor(CurrentSlot currentSlot, Sheet sheet) {
        setBackground(Color.WHITE);
        this.currentSlot = currentSlot;
        this.sheet = sheet;
        
    }
}