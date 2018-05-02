package com.wzw.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args){
		User user = new User();
		Class<User> clazz = (Class<User>) user.getClass();
		MethodHandler methodHandler = new MethodHandler();
		methodHandler.setUser(user);
		After proxyInstance = (After) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),
				methodHandler);
		proxyInstance.after();
	}
}

class MethodHandler implements InvocationHandler {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		System.out.println("advence......");
		arg1.invoke(user,arg2);
		return null;
	}
}

class User implements Before, After {

	public void say() {
		System.out.println("hello......");
	}

	@Override
	public void after() {
		System.out.println("after......");
	}

	@Override
	public void before() {
		System.out.println("before......");
	}

}

interface Before {
	void before();
}

interface After {
	void after();
}