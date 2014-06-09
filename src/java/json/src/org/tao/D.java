package org.tao;
import java.util.List;
import java.util.ArrayList;

public final class D<T> {
	public D() {
		this.nodes = new ArrayList<T>();
	}

	public final void add(final T t) {
		if (null == t) return;
		nodes.add(t);
	}

	@Override
	public final String toString() {
		final StringBuilder s = new StringBuilder();
		s.append("D=[");
		for (T t : nodes) {
			s.append("\t" + t.toString());
		}
		s.append("  ]");
		return (s.toString());
	}
	
	final List<T> nodes;
}
