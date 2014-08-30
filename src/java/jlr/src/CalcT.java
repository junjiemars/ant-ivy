import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.lang.*;
import static java.lang.System.out;

public final class CalcT extends CalcBaseListener {
	@Override
	public void enterCalc(CalcParser.CalcContext ctx) {
		out.print('"');
	}

	@Override
	public void exitCalc(CalcParser.CalcContext ctx) {
		out.print('"');
	}

	@Override
	public void enterValue(CalcParser.ValueContext ctx) {
		if (null != ctx.INT()) {			
			int value = Integer.valueOf(ctx.INT().getText());
			out.printf("\\u%04x", value);
		}
	}
}
