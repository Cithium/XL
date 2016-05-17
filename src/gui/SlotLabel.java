package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;


public class SlotLabel extends ColoredLabel implements Observer, MouseListener {
	
    private CurrentSlot currentSlot;
    private String position;
    private Sheet sheet;
    
    public SlotLabel(String position, CurrentSlot currentSlot, Sheet sheet) {
        super("                    ", Color.WHITE, RIGHT);
        addMouseListener(this);
        this.currentSlot = currentSlot;
        this.position = position;
        this.sheet = sheet;
        sheet.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Mouse update");
		String text = sheet.print(position);
		this.setText(text);
		
	//	System.out.println(sheet.value(position));
		currentSlot.deleteObserver(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		currentSlot.reset();
		System.out.println("Mouse pressed");
		this.setBackground(Color.YELLOW);
		currentSlot.set(this);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return position;
	}
}