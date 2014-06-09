package org.tao;
import static java.lang.System.out;

public abstract class Foobase<T> {
	public Foobase() {
		this.s = "Hello";
	}

	public final void base() {
		out.println("calling Foobase::base()");
	}

	public final String s() {
		return (s);
	}
	
	abstract void foo(T t);

	protected final String s;
}
