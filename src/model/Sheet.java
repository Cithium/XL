package model;

import java.util.HashMap;
import java.util.Observable;

import expr.Environment;
import util.XLException;

public class Sheet extends Observable implements Environment {

	private HashMap<String, Slot> sheetMap;
	
	public Sheet() {
		sheetMap = new HashMap<String, Slot>();
	}
	
	public void editSlot(String key, String input) {
		//Slot value = SlotFactory.create(text) // Hitta rätt typ av slot...
		Slot value = SlotTypeChecker.check(input);
		if (circularCheck(key, value)) {
			System.out.println("CHECK FEL LOL");
		} else {
			sheetMap.put(key, value);
		}
	//	sheetMap.put("A1", new TextSlot("123"));

	}
	
	public double value(String text) {
		System.out.print("TEST  :: ");
		System.out.println(text);
		Slot testSlot = sheetMap.get(text);
	/*	if (sheetMap.get(text) == null) {
			throw new XLException(text + " does not exist in the sheet.");
		}
	*/	return sheetMap.get(text).value(this);
	}
	
	public String print(String key) {
		Slot slot = sheetMap.get(key);
		if (slot == null) {
			return "";
		}
		try {
			return slot.print(this);
		} catch (XLException e) {
			return "ERROR";
		}
	}
	
	public boolean circularCheck(String key, Slot value) {
        Slot currentSlot = sheetMap.get(key);

        sheetMap.put(key, new TestSlot());

        try {
            value.value(this);
        } catch (XLException e) {
        	System.out.println("Bad input 1");
    		setChanged();
    		notifyObservers();
            //currentError = "Bad input, ";
            return true;
        } catch (NullPointerException e) {
        	System.out.println("Bad input 2");
            //currentError = "Bad input, ";
            return true;
        }

        sheetMap.put(key, currentSlot);
        return false;
	}
	
	
}
