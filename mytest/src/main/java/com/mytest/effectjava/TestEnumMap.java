package com.mytest.effectjava;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestEnumMap {

	public static void main(String[] args) {
		Map<Herb.Type,Set<Herb>> herbsByType = new EnumMap<>(Herb.Type.class);
		for(Herb.Type t:Herb.Type.values())
			herbsByType.put(t, new HashSet<Herb>());

	}

}

class Herb {
	public enum Type {
		ANNUAL, PERENNIAL, BIENNIAL
	}

	private final String name;
	private final Type type;

	Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	public String toString(){
		return name;
	}
	
	public Type getType(){
		return type;
	}
}