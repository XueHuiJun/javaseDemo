package cn.itcast.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		FileReader fileReader = new FileReader("class.properties");
		Properties properties = new Properties();
		properties.load(fileReader);
		String className = properties.getProperty("className");
		String method = properties.getProperty("method");
		Class c= Class.forName(className);
		Object object = c.newInstance();
		Method m = c.getMethod(method);
		m.invoke(object);
	}

}
