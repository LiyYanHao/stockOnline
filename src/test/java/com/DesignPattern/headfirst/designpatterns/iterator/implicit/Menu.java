package com.DesignPattern.headfirst.designpatterns.iterator.implicit;

import java.util.Iterator;

public interface Menu {
	public Iterator<MenuItem> createIterator();
}
