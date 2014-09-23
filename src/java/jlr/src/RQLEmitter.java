import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by junjie on 9/23/14.
 */
public class RQLEmitter extends RQLBaseVisitor<String> {

    @Override
    public String visitSelect(RQLParser.SelectContext ctx) {
        final String tids = ctx.tids().getText();
        final String fids = ctx.fids().getText();
        final String where = (ctx.where() == null ? null : ctx.where().getText());
        out.format("tids:%s\nfids:%s\nwhere:%s\n", tids, fids, where);

        final Zscan z = new Zscan(tids);

        final String s = String.format("zscan %s 0", tids);
        _ins.add(s);
        return (s);
    }

    public final List<String> ins() {
        return (_ins);
    }

    public final class Zscan {
        public Zscan(final String key) {
            this(key, 0);
        }
        public Zscan(final String key, int cursor) {
            _key = key;
            _cursor = cursor;
            _match = null;
            _count = 0;
        }

        public final String key() {
            return (_key);
        }

        public final int cursor() {
            return (_cursor);
        }

        public final void set_match(final String m) {
            _match = m;
        }

        public final String get_match() {
            return (_match);
        }

        public final boolean matched() {
            return (!(null == _match || _match.isEmpty()));
        }

        public final void set_count(int count) {
            _count = count;
        }

        public final int get_count() {
            return (_count);
        }

        public final boolean counted() {
            return (_count > 0);
        }

        private final String _key;
        private final int _cursor;
        private String _match;
        private int _count;
    }

    private final List<String> _ins = new ArrayList<String>();


}
