package org.tao;
import static java.lang.System.out;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.net.SocketException;

public final class Inets {
	private Inets() {}

	public static final void run(String[] args) {
		Enumeration<NetworkInterface> its = null;

		try {
			its = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			out.println(e);
		}

		if (null == its) {
			return;
		}

		while (its.hasMoreElements()) {
			NetworkInterface i = its.nextElement();
			out.println("interfaces:" + i.toString());
			
			Enumeration<InetAddress> as = i.getInetAddresses();
			while (as.hasMoreElements()) {
				InetAddress a = as.nextElement();
				out.println("\taddress:" + a.toString());	
				out.println("\thostname:" + a.getHostName());	
				//out.println("\tcanonical:" + a.getCanonicalHostName());
			}
		}

		out.println();

		InetAddress h = null;
		try {
			h = InetAddress.getLocalHost();
			out.println("host:" + h.getHostName());	
			//out.println("chost:" + h.getCanonicalHostName());
			out.println("hosted:" + h.getByName(h.getHostName()));	
			//out.println("chosted:" + h.getByName(h.getCanonicalHostName()));
		} catch (UnknownHostException e) {
			out.println("!ERROR:" + e);
		}
		out.println();
	}
}
