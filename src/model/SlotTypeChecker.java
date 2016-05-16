package model;

public class SlotTypeChecker {
	
	public static Slot check(String text) {
		if (text.length() > 0 && text.charAt(0) == '#') { //Det finns text och första karaktären är en # => CommentSlot
			String comment = text.substring(1); //Ny String som börjar efter #
			return new TextSlot(comment);
			
		}
		return new ExprSlot();
	}
}
