package com.brainmentors.apps;

import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

public class Factory {
	public static Object getBean() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		try {
			Object object = Class.forName(rb.getString("classname"))
					.getDeclaredConstructor().newInstance();
			return object;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
