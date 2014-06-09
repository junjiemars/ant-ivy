package org.tao;
import static java.lang.System.out;

public final class Args {
	private Args() {}

	public static final void run(String[] args) {
		var_args();
		//var_args(null);
		var_args("");
		var_args("a", "b", "c");
	}

	private static final void var_args(final String... s) {
		out.println(String.format("null == s : %s", null == s));
		out.println(String.format("s.length : %d", s.length));
		out.println();
	}
}
