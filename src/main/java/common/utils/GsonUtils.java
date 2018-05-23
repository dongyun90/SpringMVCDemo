package common.utils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GsonUtils {

	private static final Gson gson = new Gson();

	public static Gson getGson() {
		return gson;
	}

	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

	public static String toJson(Collection<?> collection) {
		return gson.toJson(collection);
	}

	@SuppressWarnings("unchecked")
	public static <T> T toBean(String json, Class<T> classOfT) {
		return gson.fromJson(json, classOfT);
	}

	public static List<?> getListFromJson(String json, Class<?> listType) {
		return (ArrayList<?>) gson.fromJson(json, listType);
	}

}
