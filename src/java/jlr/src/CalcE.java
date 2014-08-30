import java.util.HashMap;
import java.util.Map;
import static java.lang.System.out;

public final class CalcE extends CalcBaseVisitor<Integer> {
	
	@Override /* ID '=' expr EOS */ 
	public Integer visitAssign(CalcParser.AssignContext ctx) {
		final String id = ctx.ID().getText();
		int value = visit(ctx.expr());
		_d.put(id, value);
		return (value);
	}

	@Override /* expr EOS */
	public Integer visitEval(CalcParser.EvalContext ctx) {
		Integer value = visit(ctx.expr());
		out.printf("value:%d\n", value);
		return (0);
	}

	@Override /* INT */
	public Integer visitInt(CalcParser.IntContext ctx) {
		int value = Integer.valueOf(ctx.INT().getText());
		return (value);
	}

	@Override /* ID */
	public Integer visitId(CalcParser.IdContext ctx) {
		String id = ctx.ID().getText();
		return (_d.containsKey(id) ? _d.get(id) : 0);
	}

	@Override /* expr op=('*'|'/') expr */
	public Integer visitMuldiv(CalcParser.MuldivContext ctx) {
		int lhs = visit(ctx.expr(0));
		int rhs = visit(ctx.expr(1));
		return (ctx.op.getType() == CalcParser.MUL ?
			lhs*rhs : lhs/rhs);
	}

	@Override /* expr op=('+'|'-') expr */
	public Integer visitAddsub(CalcParser.AddsubContext ctx) {
		int lhs = visit(ctx.expr(0));
		int rhs = visit(ctx.expr(1));
		return (ctx.op.getType() == CalcParser.ADD ?
			lhs+rhs : lhs-rhs);
	}

	@Override /* '(' expr ')' */
	public Integer visitParens(CalcParser.ParensContext ctx) {
		return (visit(ctx.expr()));
	}
		
	final Map<String, Integer> _d = new HashMap<String, Integer>();
}
