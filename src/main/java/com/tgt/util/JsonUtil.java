package com.tgt.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
	private static Gson gson = (new GsonBuilder()).create();

	public JsonUtil() {
	}

	public static <T> T fromJson(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}

	public static <T> String toJson(T dto) {
		return gson.toJson(dto);
	}

	public static Gson getGson() {
		return gson;
	}
}