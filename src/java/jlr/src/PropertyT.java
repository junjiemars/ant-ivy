import static java.lang.System.out;

/**
 * Created by junjie on 9/23/14.
 */
public class PropertyT extends PropertyBaseListener {

    @Override
    public void exitProp(PropertyParser.PropContext ctx) {
        out.format("%s=%s\n", ctx.ID(), ctx.STR());
    }


}
