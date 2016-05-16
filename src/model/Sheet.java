package model;

import java.util.HashMap;
import java.util.Observable;

import util.XLException;

public class Sheet extends Observable {

	private HashMap<String, Slot> sheetMap;
	
	public Sheet() {
		sheetMap = new HashMap<String, Slot>();
	}
	
	public void editSlot(String key, String input) {
		//Slot value = SlotFactory.create(text) // Hitta rätt typ av slot...
		Slot value = SlotTypeChecker.check(input);
		
		sheetMap.put(key, value);
	//	sheetMap.put("A1", new TextSlot("123"));
	}
	
	public double value(String text) {
		System.out.print("TEST  :: ");
		System.out.println(text);
		Slot testSlot = sheetMap.get(text);
		return 22;
	}
	
	public String print(String key) {
		Slot slot = sheetMap.get(key);
		if (slot == null) {
			return "";
		}
		try {
			return slot.toString();
		} catch (XLException e) {
			return "ERROR";
		}
	}
	
	
}
