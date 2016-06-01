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
    // onödigt med sheet nu, då den inte används här längre private Sheet sheet;
    
    public SlotLabel(String position, CurrentSlot currentSlot/*, Sheet sheet*/) {
        super("                    ", Color.WHITE, RIGHT);
        addMouseListener(this);
        this.currentSlot = currentSlot;
        this.position = position;
    //    this.sheet = sheet;
    //    sheet.addObserver(this);
    }

	@Override		// ÄNDRAD, flyttat köttet till SlotLabels
	public void update(Observable o, Object arg) {
		System.out.println("SlotLabel/update");
	//	String text = sheet.print(position);
	//	this.setText(text);
		
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
		System.out.println("SlotLabel/mousePressed");
		currentSlot.reset();
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