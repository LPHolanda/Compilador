package inter;

import symbols.Type;

public class ElseIf extends Stmt {
	
	Expr expr;
	Stmt stmt;
	
	public ElseIf(Expr x, Stmt s) {
		expr = x;
		stmt = s;
		if(expr.type != Type.Bool) expr.error("boolean required in else if");
	}
	
	public void gen(int b, int a) {
		int label = newlabel();
		expr.jumping(0, a);
		emitlabel(label);
		stmt.gen(a, label);
	}

}