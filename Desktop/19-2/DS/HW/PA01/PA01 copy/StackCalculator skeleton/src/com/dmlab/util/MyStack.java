package com.dmlab.util;

import java.util.EmptyStackException;

import com.dmlab.interfaces.Stack;

/**
 * Array-based Stack
 * The size of the internal array should be 128
 */
public class MyStack<E> implements Stack<E> {
	
	private E[] mData;
	private int mCursor; // first
	
	public MyStack() {
		clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		/* Code Here */
		mData = (E[])new Object[128];
		mCursor = 0;
	}

	@Override
	public void push(E item) throws RuntimeException {
		/* Code Here */
		this.mData[mCursor % 128] = item;
		mCursor++;
	}

	@Override
	public E pop() throws EmptyStackException {
		/* Code Here */
		mCursor--;
		return this.mData[mCursor % 128];
	}

	@Override
	public E peek() throws EmptyStackException {
		/* Code Here */
		return this.mData[mCursor % 128];
	}

	@Override
	public boolean empty() {
		/* Code Here */
		return (mCursor % 128 == 0);
	}

}
