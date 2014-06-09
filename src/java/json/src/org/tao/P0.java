package org.tao;

public final class P0<T> {
	public P0(final D<T> d) {
		this.d = d;
	}

	@Override
	public final String toString() {
		final StringBuilder s = new StringBuilder();
		s.append("P0={");
		s.append("\t" + d + "}");
		return (s.toString());
	}

	final D<T> d; 
}
