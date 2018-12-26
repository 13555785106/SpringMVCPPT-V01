import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GSONTest01 {

	public static void main(String[] args) {
		JsonObject jo1 = new JsonObject();
		jo1.addProperty("name", "肖俊峰");
		jo1.addProperty("age", 45);
		String str = jo1.toString();
		System.out.println(str);
		Gson gson = new Gson();
		JsonObject jo2 = gson.fromJson(str, JsonObject.class);
		System.out.println(jo2);

	}

}
