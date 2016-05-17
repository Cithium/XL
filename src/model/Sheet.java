package model;

import java.util.HashMap;
import java.util.Observable;

import expr.Environment;
import gui.SlotLabel;
import util.XLException;

public class Sheet extends Observable implements Environment {

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
	
	public boolean insert(SlotLabel key, Slot s){
	 
		return true;
	}
	
	public boolean clearSlot(SlotLabel key, Slot s){
		if(sheetMap.containsKey(key)){
			sheetMap.remove(key);
			
		//error kod här? if error blabla?
		
		setChanged();
		notifyObservers();
		return true;
		}else{
			return false;
		}
	}
	
	public boolean clearAll(){
		return false;
		
	}
	
	public boolean loadSlots(String s){
		return true;
	}
	public boolean saveSlots(String s){
		return true;
		
	}
	
	public double value(String text) {
		System.out.print("TEST  :: ");
		System.out.println(text);
		Slot testSlot = sheetMap.get(text);
		return sheetMap.get(text).value(this);
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
