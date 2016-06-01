package model;

import expr.Environment;
import util.XLException;

public class TestSlot implements Slot {
	String text;
	public TestSlot(String input) {
		text = input;
	}

	@Override
	public double value(Environment env) {
		throw new XLException("Circular dependency detected");
	}

	@Override
	public String print(Environment env) {
		throw new XLException("Circular dependency detected");
	}

	@Override
	public String toString() {
		return text;
	}
}
