import static java.lang.System.out;
/**
 * Created by junjie on 9/23/14.
 */
public class PropertyE extends PropertyBaseVisitor<String> {
    @Override
    public String visitProp(PropertyParser.PropContext ctx) {
        out.format("%s=%s\n", ctx.ID(), ctx.STR());
        return (null);
    }
}
