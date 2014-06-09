package org.tao;
import java.util.List;
import java.util.ArrayList;

public final class A {
	public A() {
		this("AAAB", 65);
	}

	public A(String n, int v) {
		this.name = n;
		this.value = v;
		this.nodes = new ArrayList<String>();
		this.nodes.add("A-Node0");
		this.nodes.add("A-Node1");
		this.b = new B("BBBB", 128);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("\tname=" + name);
		s.append("\tvalue=" + Integer.toString(value));
		s.append("\t" + b);
		return (s.toString());
	}
		

	public final String name() {
		return (name);
	}

	public final int value() {
		return (value);
	}

	final String name;
	final int value;
	final List<String> nodes;
	final B b;

	public static final class B {
		public B(String n, int v) {
			this.name = n;
			this.value = v;
		}
		
		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append("\tname=" + name);
			s.append("\tvalue=" + Integer.toString(value));
			return (s.toString());
		}

		public final String name() {
			return (name);
		}

		public final int value() {
			return (value);
		}
		
		final String name;
		final int value;
	}
}

