package model;

import java.io.IOException;

import expr.Expr;
import expr.ExprParser;

public class SlotTypeChecker {
	
	public static Slot check(String text) {
		if (text.length() > 0 && text.charAt(0) == '#') { //Det finns text och f�rsta karakt�ren �r en # => CommentSlot
			String comment = text.substring(1); //Ny String som b�rjar efter #
			return new TextSlot(comment);
			
		}
		ExprParser exprParser = new ExprParser();
		Expr newExpr;
		try {
			System.out.println("det blev en rolig grej");
			newExpr = exprParser.build(text);
			return new ExprSlot(newExpr);
		} catch (IOException e) {			
			System.out.println("KUNDE INTE PARSA LOL");
			e.printStackTrace();
			return null;
		}
	}
}
