package com.mytest.grammar;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Scanner;

public class ReflectionTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name;
		if (args.length > 0)
			name = args[0];
		else {
			Scanner in = new Scanner(System.in);
			name = in.next();
		}

		try {
			Class c1 = Class.forName(name);
			Class superc1 = c1.getSuperclass();
			String modifiers = Modifier.toString(c1.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers);
			System.out.println(" " + name);
			if (superc1 != null && superc1 != Object.class)
				System.out.print(" " + "extends " + superc1);

			System.out.println("\n{\n");
			printConstructors(c1);
			System.out.println();
			printFields(c1);
			System.out.println();
			printMethods(c1);
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

	private static void printMethods(Class c1) {
		Method[] methods = c1.getDeclaredMethods();
		for (Method method : methods) {
			String name = method.getName();
			String modifiers = Modifier.toString(method.getModifiers());
			Class[] types= method.getParameterTypes();
			if(modifiers.length()>0) 
				System.out.print("	"+modifiers + " ");
			System.out.print(name + "(");
			for (int i = 0; i < types.length; i++) {
				if(i>0)
					System.out.print(",");
				System.out.print(types[i].getName());
			}
			System.out.println(");");
			
		}

	}

	private static void printFields(Class c1) {
		Field[] fields = c1.getDeclaredFields();
		for (Field field : fields) {
			Class type = field.getType();
			String name = field.getName();
			String modifiers = Modifier.toString(field.getModifiers());
			System.out.println("	"+modifiers+" "+type.getName()+" "+name);
		}

	}

	private static void printConstructors(Class c1) {
		Constructor[] constructors = c1.getDeclaredConstructors();

		for (Constructor constructor : constructors) {
			String name = constructor.getName();
			String modifiers = Modifier.toString(constructor.getModifiers());
			if (modifiers != null)
				System.out.print("	" + modifiers + " ");
			System.out.print(name + "(");
			Class[] type = constructor.getParameterTypes();
			for (int i = 0; i < type.length; i++) {
				if (i > 0)
					System.out.print(", ");
				System.out.print(type[i].getTypeName());
			}
			System.out.println(");");
		}
	}

}
