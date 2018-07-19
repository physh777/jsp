package com.test.jsp.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) {
		Gson gs = new Gson();
		String arr = "[1,2,3,4]";
		List<Double> numList = gs.fromJson(arr, List.class);
		for(Double num : numList) {
			System.out.println(num);
		}
		
		arr = "{\"name\":\"홍길동\",\"age\":\"20\"}";
		Map<String,String> map = gs.fromJson(arr, Map.class);
		System.out.println(map.get("name"));
		
		map = new HashMap<String,String>();
		map.put("name", "김동건");
		map.put("age", "33");
		arr = gs.toJson(map);
		System.out.println(arr);
	}
}
