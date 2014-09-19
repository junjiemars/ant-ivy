import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.lang.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public final class CalcT extends CalcBaseListener {
    public CalcT(final CalcParser parser) {
        this._parser = parser;
    }

	@Override
	public void enterCalc(CalcParser.CalcContext ctx) {
		out.print('"');
	}

	@Override
	public void exitCalc(CalcParser.CalcContext ctx) {
		out.print('"');
	}

	@Override
    public void exitAssign(CalcParser.AssignContext ctx) {
        final TokenStream t = _parser.getTokenStream();

        int v = Integer.valueOf(t.getText(ctx.expr()));
        final String k = ctx.ID().getText();
        _d.put(k, v);

        out.format("%s=%s\n", k, v);
    }

    @Override
    public void exitMuldiv(CalcParser.MuldivContext ctx) {
//        int l = Integer.valueOf(ctx.expr(0).getText());
//        int r = Integer.valueOf(ctx.expr(1).getText());

        out.println(ctx.getText());
    }

	@Override
    public void enterInt(CalcParser.IntContext ctx) {
        out.println(ctx.INT());
    }

    private CalcParser _parser;
    private final Map<String, Integer> _d = new HashMap<String, Integer>();
}
