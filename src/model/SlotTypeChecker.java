package model;

public class SlotTypeChecker {
	
	public static Slot check(String text) {
		if (text.length() > 0 && text.charAt(0) == '#') { //Det finns text och f�rsta karakt�ren �r en # => CommentSlot
			String comment = text.substring(1); //Ny String som b�rjar efter #
			return new TextSlot(comment);
			
		}
		return new ExprSlot();
	}
}
