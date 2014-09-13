package org.mars;

import java.util.Set;
import redis.clients.jedis.Jedis;
import static java.lang.System.out;

public final class NativeJedis {
	public static final void run() {
		Jedis r = new Jedis("localhost", 6379, 100);
		r.connect();
		Set<byte[]> s = r.keys("*".getBytes());
		for (byte[] b : s) {
			out.println(new String(b));
		}
		r.close();

	}
}
