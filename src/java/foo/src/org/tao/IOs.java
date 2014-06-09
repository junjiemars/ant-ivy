package org.tao;
import java.io.File;
import static java.lang.System.out;

public final class IOs {
	public static final void run(String[] args) {
		long b = System.currentTimeMillis();
		String a0 = null;
		File f0 = new File(a0);
		File f1 = new File(f0, args[1]);
		String p = f1.getPath();
		long e = System.currentTimeMillis() - b;
		out.println(String.format("ms:%d, path:%s", e, p));

	}
}
