package org.tao;
import static java.lang.System.out;
import com.google.gson.reflect.TypeToken;

public final class Main {
	public static void main(String[] args) {

		int[] ints = Args.from_json("[1,2,3]", int[].class);
		out.println("deserializing json-string to object");
		for (int i : ints) {
			out.print(i);
			out.print(" ");
		}
		out.println();

		out.println("searializing object to json-string");
		String json = Args.to_json(ints);
		out.println(json);	
		out.println();

		out.println("searializing generic-object");
		C<String> c = new C<String>("C is generic object");
		json = Args.to_json(c);
		out.println(json);
		
		out.println("deserializing generic-object");
		c = Args.from_json(json, new TypeToken<C<String>>(){}.getType());
		out.println(c);

		out.println("serializing generic-container");
		D<String> d = new D<String>();
		d.add("one");
		d.add("two");
		json = Args.to_json(d);
		out.println(json);
		
		out.println("deserializing generic-container");
		d = Args.from_json(json, new TypeToken<D<String>>(){}.getType());
		out.println(d);
		out.println();

		out.println("searializing generic-container2");
		P0<String> p0 = new P0<String>(d);
		json = Args.to_json(p0);
		out.println(json);

		out.println("deserializing generic-container2");
		p0 = Args.from_json(json, new TypeToken<P0<String>>(){}.getType());
		out.println(p0);
		out.println();

		out.println("serializing non-generic-container2");
		P1 p1 = new P1(d);
		json = Args.to_json(p1);
		out.println(json);

		out.println("deserializing non-generic-container2");
		p1 = Args.from_json(json, P1.class);
		out.println(p1);
		out.println();

		out.println("serializing custom-container");
		U u = new U(new V("v0", 1), new V("v1", 2));
		json = Args.to_json(u);
		out.println(json);

		out.println("deserializing custom-container");
		u = Args.from_json(json, U.class);
		out.println(u);
		out.println();

//		out.println("serializing A::ctor(String,int)");
//		A a = new A("AAAA", 64);
//		json = Args.to_json(a);
//		out.println(json);
//		
//		out.println("deserializing A");
//		a = Args.from_json(json, A.class);
//		out.println(a);
//		out.println();
	}




//	private static final class _AD implements JsonDeserializer<A> {
//		public A deserialize(JsonElement json, Type typeofT, 
//			JsonDeserializationContext context) {
//			
//			A t = new A();
//			return (t);	
//		}
//	}

}
