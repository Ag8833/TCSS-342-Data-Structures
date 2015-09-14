package util;
/**
 * Tyler Braden and Andrew Gates
 * Queue Data Structure.
 * Boom!
 */

import java.util.NoSuchElementException;

import interfaces.Queue;

public class LinkedQueue implements Queue {
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
		
	}

	@Override
	public boolean contains(int e) {
		Node temp = head;
		while(temp != null) {
			if (temp.value == e) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int[] toArray() {
		int[] array = new int[size];
		Node temp = head;
		if (size > 0) {
			int count = 0;
			while (count < size) {
				array[count] = temp.value;
				temp = temp.next;
				count++;
			}
			return array;
		}
		return array;
		
	}

	@Override
	public boolean offer(int e) {
		Node temp = new Node(e);
		if (e > 0) {
			if (head == null) {
				head = temp;
				tail = temp;
			} else {
				tail.next = temp;
				tail = temp;
			}
		size++;
		return true;
		} else {
			return false;
		}
	}

	@Override
	public void add(int e) {
		Node temp = new Node(e);
		if (e > 0) {
			if (head == null) {
				head = temp;
				tail = temp;
			} else {
				tail.next = temp;
				tail = temp;
				
			}
		size++;
		} else {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public int peek() {
		if (head != null) {
			return head.value;
		} else {
			return -1;
		}
	}

	@Override
	public int element() {
		if (head != null) {
			return head.value;
		} else {
			throw new NoSuchElementException();
		}
		
	}

	@Override
	public int poll() {
		if (head != null) {
			Node temp = head;
			head = head.next;
			size--;
			return temp.value;
		}
		return -1;
	}

	@Override
	public int remove() {
		if (head != null) {
			Node temp = head;
			head = head.next;
			size--;
			return temp.value;
		}
		throw new NoSuchElementException();
	}
	
	private class Node{
		public int value;
		public Node next;
		
		public Node(int e) {
			next = null;
			value = e;
		}
	}

}
