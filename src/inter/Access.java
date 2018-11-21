package inter;
import lexer.*;
import symbols.*;

public class Access extends Op {
	public Id array;
	public Expr index;
	
	public Access(Id a, Expr i, Type p) { // p � o tipo de elemento ap�s achatar o arranjo
		super(new Word("[]", Tag.INDEX), p);
		array = a;
		index = i;	
	}
	
	public Expr gen() { 
		return new Access(array, index.reduce(), type); 
	}
	
	public void jumping(int i, int f) {
		emitjumps(reduce().toString(), i, f); 
	}
	
	public String toString() {
		return array.toString() + " [ " + index.toString() + " ]";
	}
}
