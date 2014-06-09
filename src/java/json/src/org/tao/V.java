package org.tao;

public final class V {
	public V(final String n, final int c) {
		this.name = n;
		this.count = c;
	}

	public final String name() {
		return (name);
	}

	public final int count() {
		return (count);
	}
	
	final String name;
	final int count;
}
