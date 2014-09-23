import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.lang.*;
import static java.lang.System.out;

public final class SqlT extends SQLBaseListener {
	@Override
	public void enterSelect(SQLParser.SelectContext ctx) {
		out.print("enter select stat");
	}

	@Override
	public void exitSelect(SQLParser.SelectContext ctx) {
		out.print("exit select stat");
	}

//	@Override 
//	public void enterFrom(SqlParser.FromContext ctx) {
//		out.println("enter from stat");
//	}
//
//	@Override
//	public void exitFrom(SqlParser.FromContext ctx) {
//		out.println("exit from stat");
//	}
}
