package gui;

import java.awt.Color;
import java.util.Observable;

public class CurrentSlot extends Observable {
	
	private SlotLabel currentLabel;

	public void reset() {
	currentLabel.setBackground(Color.WHITE);
		// TODO Auto-generated method stub
		
	}

	public void set(SlotLabel slotLabel) {
		currentLabel = slotLabel;
		setChanged(); //??
		notifyObservers();
		addObserver(slotLabel);
		
	}
	
    public String toString(){
        return currentLabel.toString();
    }
    
    public SlotLabel getLabel() {
    	return currentLabel;
    }

}
