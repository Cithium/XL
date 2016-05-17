package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Sheet;

public class Editor extends JTextField implements ActionListener {
    private Sheet sheet;
	private CurrentSlot currentSlot;

	public Editor(CurrentSlot currentSlot, Sheet sheet) {
        setBackground(Color.WHITE);
        this.currentSlot = currentSlot;
        this.sheet = sheet;
        addActionListener(this);
        
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		sheet.insert(currentSlot.toString(), this.getText());
		this.setText("");
		currentSlot.set(currentSlot.getLabel());

	}
}