package model;

import expr.Environment;

public class TextSlot implements Slot {

	String text;
	
	public TextSlot(String text) {
		this.text = text;
	}
	@Override
	public double value(Environment env) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return text;
	}
}
