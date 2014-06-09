package org.tao;
import static java.lang.System.out;

public final class Strings {
	public Strings() {}

	public static final void run(String[] args) {
		//_split(args);
		_immutable(args);
	}

	private static final void _split(String[] args) {
		if (args.length < 2) {
			out.println("invalid args");
			return;
		}

		int limit = 0;
		if (args.length > 2) {
			limit = Integer.valueOf(args[2]);
		}

		String[] strs = Strings.split(args[0], args[1], limit);		
		for (String s : strs) {
			out.println(String.format("length:%d content:%s", s.length(), s));
		} 	
	}

	private static final void _immutable(String[] args) {
		if (args.length < 1) {
			out.println("invalid args");
			return;
		}

		String s0 = "abc";
		char[] c0 = new char[] {'a', 'b', 'c'};
		String s1 = new String(c0);
		
		out.println(String.format("a0:%d", args[0].hashCode()));
		out.println(String.format("s0:%d", s0.hashCode()));	
		out.println(String.format("s1:%d", s1.hashCode()));
	}

	public static final String[] split(String s, String d, int p) {
		if (null == s || s.length() < 1
			|| null == d || d.length() < 1) {
			return (null);
		}

		String[] r = s.split(d, p);
		return (r);
	}
}
