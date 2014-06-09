package org.tao;

import static java.lang.System.out;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;


public final class Args {
	public static final <T> String to_json(final T t) {
		if (null == t) {
			return (null);
		}
		
		final Gson g = new Gson();
		final String s = g.toJson(t);
		return (s);
	}

	public static final <T> String to_json_type(final T t) {
		if (null == t) {
			return (null);
		}

		final Type type = new TypeToken<T>(){}.getType();
		final Gson g = new Gson();
		final String s = g.toJson(t, type);
		return (s);	
	}

	public static final <T> T from_json(final String json, 
		final Class<T> clazz) {

		if (null == json || json.isEmpty() || null == clazz) {
			return (null);
		}

		final Gson g = new Gson();
		T t = null;
		try {
			t = g.fromJson(json, clazz);
		} catch (JsonSyntaxException e) {
			out.println(e);
		} catch (JsonParseException e) {
			out.println(e);
		}

		return (t);
	}

	public static final <T> T from_json(final String json,
		final Type type) {

		if (null == json || json.isEmpty() || null == type) {
			return (null);
		}

		final Gson g = new Gson();
		T t = null;
		
		try {
			t = g.fromJson(json, type);
		} catch (JsonSyntaxException e) {
			out.println(e);
		} catch (JsonParseException e) {
			out.println(e);
		}

		return (t);
	}

	public static final <T> T from_json(final String json, 
		final Class<T> clazz, 
		final TypeAdapter<T>... adapters) {

		if (null == json || json.isEmpty() 
			|| null == clazz || adapters.length < 1) {
			return (null);
		}

		final GsonBuilder gb = new GsonBuilder();
		for (TypeAdapter<T> a : adapters) {
			gb.registerTypeAdapter(clazz, a);
		}	
		final Gson g = gb.create();
		
		T t = null;
		try {
			t = g.fromJson(json, clazz);	
		} catch (JsonSyntaxException e ) {
			out.println(e);
		} catch (JsonParseException e) {
			out.println(e);
		}

		return (t);
	}
}
