package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Sheet;

public class Editor extends JTextField implements ActionListener, Observer {	// Editor implementerar Observer för att kunna uppdatera editorfältet med CurrentSlots formel
    private Sheet sheet;
	private CurrentSlot currentSlot;

	public Editor(CurrentSlot currentSlot, Sheet sheet) {
        setBackground(Color.WHITE);
        this.currentSlot = currentSlot;
        this.sheet = sheet;
        addActionListener(this);
        currentSlot.addObserver(this);
        
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		sheet.insert(currentSlot.toString(), this.getText());
		this.setText("");
		currentSlot.set(currentSlot.getLabel());

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("Editor/update");
		this.setText(sheet.getEquation(currentSlot.getLabel().toString()));
	}
}