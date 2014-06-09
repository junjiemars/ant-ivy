package org.tao.generics;
import static java.lang.System.out;
import java.util.List;
import java.util.ArrayList;

public final class Boxing {
	public static final void sum(int count, int who) {
		List<Integer> ints = new ArrayList<Integer>(count);
		for (int i = 0; i < count; i++) {
			ints.add(i);
		}

		//if (who == 0) {
		//	sumInt(ints);
		//} else if (who == 1) {
		//	sumInteger(ints);
		//}
		cache(ints);
	}

	private static final void cache(List<Integer> ints) {
		// int -128~127
		// char \u0000~\u007f
		if (sumInt(ints) == sumInteger(ints)) {
			out.println("sumInt == sumInteger");
		} else 
			out.println("sumInt != sumInteger");

	}

	private static final int sumInt(final List<Integer> ints) {
		//long begin = System.currentTimeMillis();
		int s = 0;
		for (int i : ints) {
			s += i;
		}
		//long end = System.currentTimeMillis() - begin;
		//out.println(String.format("case0 cost %d ms", end));
	}

	private static final void sumInteger(final List<Integer> ints) {
		long begin = System.currentTimeMillis();
		Integer s = 0;
		for (Integer i : ints) {
			s += i;
		}	
		long end = System.currentTimeMillis() - begin;
		out.println(String.format("case1 cost %d ms", end));
	}

}
