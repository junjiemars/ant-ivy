package org.mars;
import static java.lang.System.out;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class Main {
	public static final void main(String[] args) {
		out.println("Jedis");
		
		Jedis r = new Jedis("as0", 6379, 100);
		r.connect();
		Set<byte[]> s = r.keys("*".getBytes());
		for (byte[] b : s) {
			out.println(new String(b));
		}
	}

}
