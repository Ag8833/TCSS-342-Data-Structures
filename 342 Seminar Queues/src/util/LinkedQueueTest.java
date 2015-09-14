package util;

import java.util.NoSuchElementException;

import org.junit.Test;

import junit.framework.TestCase;

public class LinkedQueueTest extends TestCase {
	
	LinkedQueue q;

	protected void setUpBeforeClass() throws Exception {
	}
	
	protected void setUp() {
		q = new LinkedQueue();
	}

	public void testClear() {
		q.offer(5);
		assertFalse(q.isEmpty());
		q.clear();
		assertTrue(q.isEmpty());
	}

	public void testContains() {
		q.offer(4);
		q.offer(6);
		q.offer(8);
		assertTrue(q.contains(8));
		assertFalse(q.contains(7));
		
	}

	public void testIsEmpty() {
		assertTrue(q.isEmpty());
		q.offer(5);
		assertFalse(q.isEmpty());
	}

	public void testSize() {
		assertEquals(0, q.size());
		q.offer(5);
		assertEquals(1, q.size());
		q.offer(6);
		assertEquals(2, q.size());
	}

	public void testToArray() {
		int[] res = q.toArray();
		assertNotNull(res);
		assertEquals(0, res.length);
		q.offer(4);
		q.offer(6);
		q.offer(5);
		res = q.toArray();
		assertEquals(3, res.length);
		assertEquals(4, res[0]);
		assertEquals(6, res[1]);
		assertEquals(5, res[2]);
	}

	public void testOffer() {
		boolean res;
		
		res = q.offer(5);
		assertEquals(1, q.size());
		assertTrue(res);
		q.offer(6);
		assertEquals(2, q.size());
		
		res = q.offer(-45);
		assertFalse(res);
		assertEquals(2, q.size());
	}

	public void testPeek() {
		assertEquals(-1, q.peek());
		
		q.offer(5);
		q.offer(6);

		assertEquals(5, q.peek());
		assertEquals(2, q.size());
	}

	public void testPoll() {
		assertEquals(-1, q.peek());
		
		q.offer(5);
		q.offer(6);
		assertEquals(2, q.size());

		assertEquals(5, q.poll());
		assertEquals(1, q.size());
		
		assertEquals(6, q.poll());
		assertEquals(0, q.size());
		
		assertEquals(-1, q.poll());
		assertEquals(0, q.size());
	}


}
