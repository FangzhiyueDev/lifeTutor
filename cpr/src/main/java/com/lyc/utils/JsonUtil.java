package com.lyc.utils;

import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {

	/**
	 * 转换为json字符串
	 * 
	 * @param 待转换的对象
	 * @return 目标json字符串
	 */
	public static String ToJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	/**
	 * 转换为对象
	 * 
	 * @param json字符串
	 * @param 目标对象类型
	 * @return 目标对象
	 */
	public static <T> T ToObject(String json, Class<T> t) {
		try {
			Gson gson = new Gson();
			
			return gson.fromJson(json, t);
		} catch (Exception e) {
			return null;
		}

	}
	
	public static HashMap<String, String> toMap(String json){
		  Gson gson = new Gson();
		  HashMap map=  (HashMap)gson.fromJson(json, new TypeToken<HashMap<String, String>>(){}.getType());
	      return map;
	   }

	public static <T> T ToObjectByType(String json, Type t) {
		try {
			Gson gson = new Gson();

			return gson.fromJson(json, t);
		} catch (Exception e) {
			LogUtil.WriteLog(e);
			return null;
		}

	}

}
