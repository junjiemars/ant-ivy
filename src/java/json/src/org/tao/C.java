package org.tao;

public final class C<T> {
	public C(final T t) {
		this.t = t;
	}

	@Override
	public final String toString() {
		final StringBuilder s = new StringBuilder();
		s.append("c=" + t);
		return (s.toString());
	}

	final T t;	
}

