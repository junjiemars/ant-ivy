package org.tao;
import static java.lang.System.out;

public class Nested {
	
	public static final void static_run(String[] args) {
		_Static s = new _Static(args[0]);
		out.println("nested static name:" + s.name());

		/*!NOTE: 
		  	 non-static nested class cannot be found in
		 	 static methods;
		*/
		//_NonStatic ns = new _NoneStatic(args[0]);
		//out.println("nested non-static name:" + ns.name());
	}

	public final void nonstatic_run(String[] args) {
		/*!NOTE:
			u can access nested instance class private/public/protected	
		*/
		_NonStatic ns = new _NonStatic(args[0]);
		out.println("nested non-static name:" + ns.name());
	}
	
	// private nested static class
	static final class _Static {
		public _Static(String n) {
			this.name = n;
		}

		public final String name() {
			return (name);
		}

		final String name;
	}

	// private nested non-static class
	final class _NonStatic {
		public _NonStatic(String n) {
			this.name = n;
		}

		public final String name() {
			return (name);
		}

		final String name;
	}
}
