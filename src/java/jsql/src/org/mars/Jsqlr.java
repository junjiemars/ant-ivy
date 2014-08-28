package org.mars;

public final class Jsqlr {
	public enum sql {
		SELECT,
		INSERT,
		UPDATE
	}
	
	public final class Field {
		public Field(final String s) {
			_v = _s = s;
		}
		
		public final String get_s() {
			return _s;
		}
		public final String get_r() {
			return _r;
		}
		public final void set_r(final String r) {
			_r = r;
		}
		public final String get_v() {
			return _v;
		}
		public final void set_v(final String v) {
			_v = v;
		}
		
		private String _s;
		private String _r;
		private String _v;
	}
	
	public final class Table {
		public Table(final String s) {
			_s = s;
			_r = _s + "_id";
		}
		
		public final String get_s() {
			return _s;
		}
		public final String get_r() {
			return _r;
		}

		private String _s;
		private String _r; 
	}
}
