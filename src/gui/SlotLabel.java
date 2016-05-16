package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;


public class SlotLabel extends ColoredLabel implements Observer/*, MouseListener*/ {
	
    private CurrentSlot currentSlot;
    private String position;
    private Sheet sheet;
    
    public SlotLabel(String position, CurrentSlot currentSlot, Sheet sheet) {
        super("                    ", Color.WHITE, RIGHT);
      //addMouseListener(this);
        this.currentSlot = currentSlot;
        this.position = position;
        this.sheet = sheet;
        sheet.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}