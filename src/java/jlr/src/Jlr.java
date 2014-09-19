import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.StringReader;

import static java.lang.System.out;

public final class Jlr {
	public static void main(String[] args) throws Exception {
        ANTLRInputStream in = null;
        if (args.length > 0) {
            final StringReader reader = new StringReader(args[0]);
            in = new ANTLRInputStream(reader);
        } else {
            in = new ANTLRInputStream(System.in);
        }
		calcT(in); // build with -listener -no-visitor
//		calcE(in); // build with -no-listener -visitor
		//sqlT(in);
//		sqlR(in);

	}

	static final void sqlR(final ANTLRInputStream in) throws Exception {
		SqlLexer l = new SqlLexer(in);
		CommonTokenStream t = new CommonTokenStream(l);
		SqlParser p = new SqlParser(t);

		ParseTree tree = p.sql();
		out.println(tree.toStringTree(p));

		SqlVisitor e = new SqlR();
		e.visit(tree);
	}

	static final void sqlT(final ANTLRInputStream in) throws Exception {
		SqlLexer l = new SqlLexer(in);
		CommonTokenStream t = new CommonTokenStream(l);
		SqlParser p = new SqlParser(t);

		ParseTree tree = p.sql();
		out.println(tree.toStringTree(p));

		ParseTreeWalker w = new ParseTreeWalker();
		w.walk(new SqlT(), tree);
		out.println();
	
	}

	static final void calcT(final ANTLRInputStream in) throws Exception {
		CalcLexer l = new CalcLexer(in);
		CommonTokenStream t = new CommonTokenStream(l);
		CalcParser p = new CalcParser(t);

		ParseTree tree = p.calc();
		out.println(tree.toStringTree(p));

		ParseTreeWalker w = new ParseTreeWalker();
        final CalcT T = new CalcT(p);
		w.walk(T, tree);
		out.println();
	}

	static final void calcE(final ANTLRInputStream in) throws Exception {
		CalcLexer l = new CalcLexer(in);
		CommonTokenStream t = new CommonTokenStream(l);
		CalcParser p = new CalcParser(t);

		ParseTree tree = p.calc();
		out.println(tree.toStringTree(p));

		CalcVisitor e = new CalcE();
		e.visit(tree);
	}
}
