import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import static java.lang.System.out;

public final class Jlr {
	public static void main(String[] args) throws Exception {
		calc(args);
	}

	private static void calc(final String[] args) throws Exception {
		ANTLRInputStream in = new ANTLRInputStream(System.in);
		CalcLexer l = new CalcLexer(in);
		CommonTokenStream t = new CommonTokenStream(l);
		CalcParser p = new CalcParser(t);

		ParseTree tree = p.calc();
		out.println(tree.toStringTree(p));

		ParseTreeWalker w = new ParseTreeWalker();
		w.walk(new CalcT(), tree);
		out.println();
	}
}
