package com.fengjr.android.listener;

import java.util.List;

public interface TraversalListener<T> {

	void start();
	
	boolean findItem(T item);
	
	void end(List<T> allItems);
}
