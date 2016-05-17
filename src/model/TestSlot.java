package model;

import expr.Environment;
import util.XLException;

public class TestSlot implements Slot {
	
	public TestSlot() {
		
	}

	@Override
	public double value(Environment env) {
		System.out.println("Circulargrej");
		throw new XLException("Circular depend");
	}

	@Override
	public String print(Environment env) {
		System.out.println("Wow inget att skriva ut");
		throw new XLException("wowww, inget att skriva ut");
	}

}
