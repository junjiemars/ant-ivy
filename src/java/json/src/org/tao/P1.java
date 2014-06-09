package org.tao;

public final class P1 {
	public P1(final D<String> d) {
		this.d = d;
	}

	@Override
	public final String toString() {
		final StringBuilder s = new StringBuilder();
		s.append("P1={");
		s.append("\t" + d + "}");
		return (s.toString());
	}
	
	final D<String> d;
}

