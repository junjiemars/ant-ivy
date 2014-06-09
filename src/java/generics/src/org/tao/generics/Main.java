package org.tao.generics;
import static java.lang.System.out;
import java.util.Arrays;

public final class Main {
	public static final void main(String[] args) {
		//varargs(1, 2, 3);

		int c = Integer.valueOf(args[0]);
		int	m = Integer.valueOf(args[1]); 
		Boxing.sum(c, m);
	}
	
	private static <T> void varargs(T... args) {
		if (null == args || args.length < 1) {
			out.println("empty varargs");
		}

		for (T t : args) {
			out.println(String.format("%s", t.toString()));
		}
	}

		
}

