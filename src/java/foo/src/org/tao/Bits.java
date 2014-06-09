package org.tao;
import static java.lang.System.out;
import java.util.BitSet;

public final class Bits {
	private Bits() {}

	public static final void run(String[] args) {
		BitSet bs0 = new BitSet();
		for (int i = 0; i < 8; i++) {
			out.println(bs0.get(i));	
		}
	}
}
