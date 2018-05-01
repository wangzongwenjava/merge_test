package com.wzw.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MockTest {
	
	@Test
	public void mockTest1(){
		List<String> list = Mockito.mock(ArrayList.class);
		list.add("1");
		list.clear();
		
		Mockito.verify(list).add("1");
		Mockito.verify(list).clear();
	}
	
	@Test
	public void when_thenReturn(){
		Iterator iterator = Mockito.mock(Iterator.class);
		Mockito.when(iterator.next()).thenReturn("hello").thenReturn("world");
		String result = iterator.next() + "  " + iterator.next() + "  " +iterator.next();
		Assert.assertEquals("hello world world", result);
	}
	
}
