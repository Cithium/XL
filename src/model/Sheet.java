package model;

import java.util.HashMap;
import java.util.Observable;

import expr.Environment;
import gui.SlotLabel;
import util.XLException;

public class Sheet extends Observable implements Environment {

	private HashMap<String, Slot> sheetMap;
	String errorMessage;
	
	public Sheet() {
		sheetMap = new HashMap<String, Slot>();
		errorMessage = "";
	}
	
	public void editSlot(String key, String input) {
		//Slot value = SlotFactory.create(text) // Hitta r�tt typ av slot...
		Slot value = SlotTypeChecker.check(input);
		if (circularCheck(key, value)) {
			errorMessage = "ERROR";

		} else {
			sheetMap.put(key, value);
			errorMessage = "";			
		}
		setChanged();
		notifyObservers();

	//	sheetMap.put("A1", new TextSlot("123"));

	}
	
	public boolean insert(SlotLabel key, Slot s){
	 
		return true;
	}
	
	public boolean clearSlot(SlotLabel key){
		System.out.println("if contains: " + key.toString());
		if(sheetMap.containsKey(key.toString())){
			sheetMap.remove(key.toString());
			System.out.println("WOW LOL");
		//error kod h�r? if error blabla?
		
		setChanged();
		notifyObservers();
		return true;
		}else{
			return false;
		}
	}
	
	public void clearAll(){
		sheetMap = new HashMap<String, Slot>();
		errorMessage = "";
		setChanged();
		notifyObservers();
		
	}
	
	public boolean loadSlots(String s){
		return true;
	}
	public boolean saveSlots(String s){
		return true;
		
	}
	
	public String getError() {
		System.out.println("Sheet/getError: " + errorMessage);
		return errorMessage;
	}
	
	public double value(String text) {
		System.out.print("TEST  :: ");
		System.out.println(text);
		
		if (sheetMap.get(text) == null) {
			throw new XLException(text + " ger n�got fel");
		}
		
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
			errorMessage = "ERROR2";
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
	
	public void loadMap(HashMap<String, Slot> map) {
		sheetMap = map;
	}
}
