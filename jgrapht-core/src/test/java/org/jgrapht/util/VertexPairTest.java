package org.jgrapht.util;

import java.util.*;
import junit.framework.*;

public class VertexPairTest extends TestCase {

	public void testGetFirst()
	{
		VertexPair v = new VertexPair (1, 2);
		assertEquals (1, v.getFirst());
	}

	public void testGetSecond()
	{
		VertexPair v = new VertexPair(1, 2);
		assertEquals (2, v.getSecond());
		
	}

	public void testHasVertex()
	{
		VertexPair v = new VertexPair(1, 2);
		assertTrue (v.hasVertex(2));
	}

	public void testGetOther1()
	{
		VertexPair v = new VertexPair(1, 2);
		assertEquals (1, v.getOther(2));
	}


	// Should throw proper error
	public void testGetOther2()
	{
		VertexPair v = new VertexPair(1, 2);
		assertEquals (1, v.getOther(3));
	}

	public void testToString()
	{
		VertexPair v = new VertexPair(1, 2);
		assertEquals ("1,2", v.toString());
	}


	public void testEquals1()
	{
		VertexPair v = new VertexPair(1, 2);
		VertexPair u = new VertexPair(1, 2);
		assertTrue (v.equals(u));
	}


	public void testEquals2()
	{
		VertexPair v = new VertexPair(1, 2);
		VertexPair u = new VertexPair(2, 1);
		assertFalse(v.equals(u));
	}


	public void testHashCode()
	{
		VertexPair v = new VertexPair(1, 2);
		assertEquals(33, v.hashCode());
	}


}
