package org.tao;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static final void main(String[] args) {
		double f0 = 1.0f;
		if (1.0f == f0)
			out.println("1.0f equal");
		else 
			out.println("not equal");

		if (1.000000001f == f0) 
			out.println("1.0000000f equal");
		else
			out.println("not equal");

		out.println(1.00000001f - f0);
		if (1.11f - f0 > 0.1f) 
			out.println("1.11f-f0>0.1f");
		/*
		String[] ss = new String[]{"A","B","C"};
		List<String> l = Arrays.asList(ss);
		for (String s : l) 
			out.println(s);
		*/
	}

}
