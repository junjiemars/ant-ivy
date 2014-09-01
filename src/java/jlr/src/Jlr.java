import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import static java.lang.System.out;

public final class Jlr {
	public static void main(String[] args) throws Exception {
		//calcT(args); // build with -listener -no-visitor
		//calcE(args); // build with -no-listener -visitor
		//sqlT(args);
		sqlR(args);
	}

	static final void sqlR(final String[] args) throws Exception {
		ANTLRInputStream in = new ANTLRInputStream(System.in);
		SqlLexer l = new SqlLexer(in);
		CommonTokenStream t = new CommonTokenStream(l);
		SqlParser p = new SqlParser(t);

		ParseTree tree = p.sql();
		out.println(tree.toStringTree(p));

		SqlVisitor e = new SqlR();
		e.visit(tree);
	}

	static final void sqlT(final String[] args) throws Exception {
		ANTLRInputStream in = new ANTLRInputStream(System.in);
		SqlLexer l = new SqlLexer(in);
		CommonTokenStream t = new CommonTokenStream(l);
		SqlParser p = new SqlParser(t);

		ParseTree tree = p.sql();
		out.println(tree.toStringTree(p));

		ParseTreeWalker w = new ParseTreeWalker();
		w.walk(new SqlT(), tree);
		out.println();
	
	}

	static final void calcT(final String[] args) throws Exception {
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

	static final void calcE(final String[] args) throws Exception {
		ANTLRInputStream in = new ANTLRInputStream(System.in);
		CalcLexer l = new CalcLexer(in);
		CommonTokenStream t = new CommonTokenStream(l);
		CalcParser p = new CalcParser(t);

		ParseTree tree = p.calc();
		out.println(tree.toStringTree(p));

		CalcVisitor e = new CalcE();
		e.visit(tree);
	}
}
