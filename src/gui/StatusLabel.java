package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class StatusLabel extends ColoredLabel implements Observer {
	Sheet sheet;
	
    public StatusLabel(Sheet sheet) {
        super("", Color.WHITE);
        this.sheet = sheet;
        sheet.addObserver(this);
    }

    public void update(Observable observable, Object object) {
    	System.out.println("StatusLabel/update");
        setText(sheet.getError());
    }
}