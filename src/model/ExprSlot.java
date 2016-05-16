package model;

import expr.Environment;
import expr.Expr;

public class ExprSlot implements Slot {

	private Expr expr;
	
	public ExprSlot(Expr expr) {
		this.expr = expr;
	}
	
	@Override
	public double value(Environment env) {
		// TODO Auto-generated method stub
		return expr.value(env);
	}
	
	public String toString() {
		return expr.toString();
	}

	@Override
	public String print(Environment env) {
		// TODO Auto-generated method stub
		return Double.toString(value(env));
	}

}
