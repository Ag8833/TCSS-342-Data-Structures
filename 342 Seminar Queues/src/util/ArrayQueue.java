package util;
/**
 * Tyler Braden and Andrew Gates
 * Queue Data Structure.
 * not quite boom.
 */

import java.util.NoSuchElementException;

import interfaces.Queue;

public class ArrayQueue implements Queue{
	
	private int front;
	private int back;
	private int[] myArray;
	
	public ArrayQueue() {
		front = 0;
		back = 0;
		myArray = new int[10];
		
	}

	@Override
	public void clear() {
		front = 0;
		back = 0;
	}

	@Override
	public boolean contains(int e) {
		for (int i = 0; i < size(); i++) {
			if (myArray[i] == e) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (front == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return back + 1;
	}

	@Override
	public int[] toArray() {
		int[] array = new int[size()];
		int count = 0;
		while (count < size()) {
			array[count] = myArray[count];
		}
		return array;
	}

	@Override
	public boolean offer(int e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int peek() {
		if (!isEmpty()) {
			return myArray[front];
		}
		return -1;
	}

	@Override
	public int element() {
		if (peek() == -1) {
			throw new NoSuchElementException();
		} else {
			return peek();
		}
	}

	@Override
	public int poll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove() {
		// TODO Auto-generated method stub
		return 0;
	}

}
