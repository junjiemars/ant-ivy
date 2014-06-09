package org.tao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import static java.lang.System.out;
import gnu.getopt.Getopt;

public final class Main {
	public static void main(String[] args) {
		Getopt g = new Getopt("", args, "s:p:");
		
//		for (String s : args) {
//			for (Pattern p : group_patterns) {
//				Matcher m = p.matcher(s);
//				if (null == m || !m.find()) {
//					print("%s not matching: %s", s, p.pattern());
//				} else {
//					print("%s matching %s, grouped %d", 
//						s, p.pattern(), m.groupCount());
//					for (int i = 0; i < m.groupCount(); i++) {
//						print("\tgroup: %s", m.group(i));
//					}
//				}
//			}		
//		}
	}

	static final void print(String f, Object... args) {
		String s = String.format(f, args);
		System.out.println(s);
	}

	static final Pattern[] group_patterns = 
		{
			//Pattern.compile("<A/>"),
			Pattern.compile("<A>(.*)</A>", Pattern.MULTILINE)
		};
}
