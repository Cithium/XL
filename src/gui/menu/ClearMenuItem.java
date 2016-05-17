package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import gui.CurrentSlot;
import gui.SlotLabel;
import model.Sheet;

class ClearMenuItem extends JMenuItem implements ActionListener {
	
	private Sheet sheet;
	private CurrentSlot currentSlot;
	
    public ClearMenuItem(Sheet sheet, CurrentSlot currentSlot) {
        super("Clear");
        this.sheet = sheet;
        this.currentSlot = currentSlot;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	SlotLabel slot = currentSlot.getLabel();
        sheet.clearSlot(slot);
    }
}