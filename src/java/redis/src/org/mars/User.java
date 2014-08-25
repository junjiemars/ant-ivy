package org.mars;

public final class User {
	public User(int id, String name, String passwd) {
		this._id=id;
		this._name=name;
		this._passwd=passwd;
	}
	
	public final int get_uid() {
		return _id;
	}
	public final void set_uid(int _uid) {
		this._id = _uid;
	}
	public final String get_uname() {
		return _name;
	}
	public final void set_uname(String _uname) {
		this._name = _uname;
	}
	public final String get_passwd() {
		return _passwd;
	}
	public final void set_passwd(String _passwd) {
		this._passwd = _passwd;
	}
	public final String get_auth() {
		return _auth;
	}
	public final void set_auth(String _auth) {
		this._auth = _auth;
	}
	
	private int _id;
	private String _name;
	private String _passwd;
	private String _auth;
}
