package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

import expr.Environment;
import gui.SlotLabel;
import util.XLException;

public class Sheet extends Observable implements Environment {

	private HashMap<String, Slot> sheetMap;
	private String errorMessage;
	
	public Sheet() {
		sheetMap = new HashMap<String, Slot>();
		errorMessage = "";
	}
	
	public void insert(String key, String input) {

		//Slot value = SlotFactory.create(text) // Hitta rätt typ av slot...
		Slot value = SlotTypeChecker.check(input);
		if (circularCheck(key, value)) {
			errorMessage = "ERROR";

		} else {
			sheetMap.put(key, value);
			errorMessage = "";			

		}

		setChanged();
		notifyObservers();

	}
	
	
	public boolean clearSlot(SlotLabel key){
		if(sheetMap.containsKey(key.toString())){
			sheetMap.remove(key.toString());
		//error kod här? if error blabla?
		
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
	
	public Set<Entry<String,Slot>> getAllEntries(){
		return sheetMap.entrySet();
	}
	
	public boolean loadSlots(String s){
		return true;
	}
	public boolean saveSlots(String s){
		return true;
		
	}
	
	public String getError() {
		return errorMessage;
	}
	
	public double value(String text) {

		if (sheetMap.get(text) == null) {
			throw new XLException("There is nothing in slot " + text);
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
			errorMessage = "ERROR";
			return "ERROR";
		}
	}
	public void loadMap(HashMap<String, Slot> map){ //behövs för loadMenuItem
		boolean errorInEntry = false;
		HashMap<String,Slot> temp = this.sheetMap;
		this.sheetMap = map;
		Iterator<Entry<String, Slot>> itr = map.entrySet().iterator();
		
		while(itr.hasNext()&&!errorInEntry){
			Entry<String,Slot> entry = itr.next();
			if(circularCheck(entry.getKey(),entry.getValue())){
				errorMessage = errorMessage +"Cannot load these files";
				this.sheetMap = temp;
				errorInEntry=true;
			}
			
		}
		sheetMap = map;
		setChanged();
		notifyObservers();
		errorMessage="";

		
	}
	public boolean circularCheck(String key, Slot value) {
        Slot currentSlot = sheetMap.get(key);

        sheetMap.put(key, new TestSlot());

        try {
            value.value(this);
        } catch (XLException e) {
    		setChanged();
    		notifyObservers();
            return true;
        } catch (NullPointerException e) {
            return true;
        }

        sheetMap.put(key, currentSlot);
        return false;
	}
}
