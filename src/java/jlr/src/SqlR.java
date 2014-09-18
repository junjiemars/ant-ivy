import java.util.HashMap;
import java.util.Map;
import static java.lang.System.out;

public final class SqlR extends SqlBaseVisitor<String> {

    @Override
    public String visitStat(SqlParser.StatContext ctx) {
        final String s = visitSelect(ctx.select());
        return (s);
    }

//	@Override /* tid */
//	public String visitTid(SqlParser.TidContext ctx) {
//		final String s = String.format("zscan %s 0", ctx.ID());
//		out.println(s);
//		return (s);
//	}

//	@Override /* expr EOS */
//	public Integer visitEval(SqlParser.EvalContext ctx) {
//		Integer value = visit(ctx.expr());
//		out.printf("value:%d\n", value);
//		return (0);
//	}
//
//	@Override /* INT */
//	public Integer visitInt(SqlParser.IntContext ctx) {
//		int value = Integer.valueOf(ctx.INT().getText());
//		return (value);
//	}
//
//	@Override /* ID */
//	public Integer visitId(SqlParser.IdContext ctx) {
//		String id = ctx.ID().getText();
//		return (_d.containsKey(id) ? _d.get(id) : 0);
//	}
//
//	@Override /* expr op=('*'|'/') expr */
//	public Integer visitMuldiv(SqlParser.MuldivContext ctx) {
//		int lhs = visit(ctx.expr(0));
//		int rhs = visit(ctx.expr(1));
//		return (ctx.op.getType() == SqlParser.MUL ?
//			lhs*rhs : lhs/rhs);
//	}
//
//	@Override /* expr op=('+'|'-') expr */
//	public Integer visitAddsub(SqlParser.AddsubContext ctx) {
//		int lhs = visit(ctx.expr(0));
//		int rhs = visit(ctx.expr(1));
//		return (ctx.op.getType() == SqlParser.ADD ?
//			lhs+rhs : lhs-rhs);
//	}
//
//	@Override /* '(' expr ')' */
//	public Integer visitParens(SqlParser.ParensContext ctx) {
//		return (visit(ctx.expr()));
//	}
//		
//	final Map<String, Integer> _d = new HashMap<String, Integer>();
}
