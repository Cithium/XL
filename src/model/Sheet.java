package model;

import java.util.HashMap;
import java.util.Observable;

public class Sheet extends Observable {

	private HashMap<String, Slot> sheetMap;
	
	public Sheet() {
		sheetMap = new HashMap<String, Slot>();
	}
	
	public void editSlot(String key, String input) {
		//Slot value = SlotFactory.create(text) // Hitta rätt typ av slot...
		Slot value = SlotTypeChecker.check(input);
		
		sheetMap.put(key, value);
		sheetMap.put("A1", new TextSlot("123"));
	}
	
	public double value(String text) {
		System.out.println("TEST");
		Slot testSlot = sheetMap.get(text);
		System.out.println(sheetMap.get("A1"));
		return 22;
	}
}
