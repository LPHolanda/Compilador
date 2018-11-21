package inter;
import symbols.*;

public class For extends Stmt{
	Expr expr;
	Stmt stmt;
	
	public For() {
		expr = null;
		stmt = null;
	}
	
	//copiado do while
	public void init (Expr x, Stmt s) {
		expr = x;
		stmt = s;
		if(expr.type != Type.Bool) expr.error("boolean required in for");
	}
	
	//copiado do while
	public void gen(int b , int a) {
		after = a;
		expr.jumping(0, a);
		int label = newlabel();
		emitlabel(label);
		stmt.gen(label, b);
		emit("goto L" + b);
	}

}
