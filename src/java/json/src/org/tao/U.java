package org.tao;

import java.util.Arrays;
import java.util.List;

public final class U {
	public U(final V... nodes) {
		this.nodes = Arrays.asList(nodes);
	}

	public final List<V> nodes() {
		return (nodes);
	}

	@Override 
	public final String toString() {
		
	}

	final List<V> nodes;	
}
