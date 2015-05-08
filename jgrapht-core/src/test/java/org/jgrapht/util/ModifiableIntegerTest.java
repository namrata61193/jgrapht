package org.jgrapht.util;

import java.util.*;
import junit.framework.*;

public class ModifiableIntegerTest extends TestCase {

	
	ModifiableInteger m = new ModifiableInteger(10);	

	public void testSet()
	{
		ModifiableInteger newM = new ModifiableInteger();
		newM.setValue(10);
		assertEquals(10, newM.getValue());
	}

	public void testDouble()
	{
		assertEquals(10.0, m.doubleValue());
	}

	
	public void testInt()
	{
		assertEquals(10, m.intValue());
	}
	

	public void testLong()
	{
		assertEquals(10, m.longValue());
	}

	public void testFloat()
	{
		assertEquals(10.0f, m.floatValue());
	}

	public void testIncrement()
	{
		m.increment();
		assertEquals(11, m.getValue());
	}

	/*public void testIncrementDouble()
	{
		ModifiableInteger m = new ModifiableInteger(10);
		m.setValue(m.doubleValue());
		m.increment();
		assertEquals(11, m.getValue());
	}*/

	public void testCompareToEqual()
	{
		ModifiableInteger n = new ModifiableInteger(10);
		assertEquals(0, m.compareTo(n));
	}

	public void testCompareToLess()
	{
		ModifiableInteger n = new ModifiableInteger(5);
		assertEquals(1, m.compareTo(n));
	}


	public void testCompareToGreater()
	{
		ModifiableInteger n = new ModifiableInteger(11);
		assertEquals(-1, m.compareTo(n));
	}

	public void testEquals1()
	{
		ModifiableInteger n = new ModifiableInteger(5);
		assertEquals(false, m.equals(n));
	}

	public void testEquals2()
	{
		int n = 10;
		assertEquals(false, m.equals(n));
	}


	public void testHashCode()
	{
		assertEquals(10, m.hashCode());
	}

	public void testToInteger()
	{
		Integer x = new Integer (10);
		assertEquals(x, m.toInteger());
	}

	public void testToString()
	{
		assertEquals("10", m.toString());
	}


}
