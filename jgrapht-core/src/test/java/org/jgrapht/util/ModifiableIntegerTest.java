package org.jgrapht.util;

import java.util.*;
import junit.framework.*;

public class ModifiableIntegerTest extends TestCase {

	public void testSet()
	{
		ModifiableInteger m = new ModifiableInteger();
		m.setValue(10);
		assertEquals(10, m.getValue());
	}

	public void testDouble()
	{
		ModifiableInteger m = new ModifiableInteger(10);
		assertEquals(10.0, m.doubleValue());
	}

	
	public void testInt()
	{
		ModifiableInteger m = new ModifiableInteger(10);
		assertEquals(10, m.intValue());
	}
	

	public void testLong()
	{
		ModifiableInteger m = new ModifiableInteger(10);
		assertEquals(10, m.longValue());
	}

	public void testFloat()
	{
		ModifiableInteger m = new ModifiableInteger(10);
		assertEquals(10.0f, m.floatValue());
	}

	public void testIncrement()
	{
		ModifiableInteger m = new ModifiableInteger(10);
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
		ModifiableInteger m = new ModifiableInteger(10);	
		ModifiableInteger n = new ModifiableInteger(10);
		assertEquals(0, m.compareTo(n));
	}

	public void testCompareToLess()
	{
		ModifiableInteger m = new ModifiableInteger(10);	
		ModifiableInteger n = new ModifiableInteger(5);
		assertEquals(1, m.compareTo(n));
	}


	public void testCompareToGreater()
	{
		ModifiableInteger m = new ModifiableInteger(5);	
		ModifiableInteger n = new ModifiableInteger(10);
		assertEquals(-1, m.compareTo(n));
	}

	public void testEquals1()
	{
		ModifiableInteger m = new ModifiableInteger(10);	
		ModifiableInteger n = new ModifiableInteger(5);
		assertEquals(false, m.equals(n));
	}

	public void testEquals2()
	{
		ModifiableInteger m = new ModifiableInteger(10);	
		int n = 10;
		assertEquals(false, m.equals(n));
	}


	public void testHashCode()
	{
		ModifiableInteger m = new ModifiableInteger(10);	
		assertEquals(10, m.hashCode());
	}

	public void testToInteger()
	{
		ModifiableInteger m = new ModifiableInteger(10);	
		Integer x = new Integer (10);
		assertEquals(x, m.toInteger());
	}

	public void testToString()
	{
		ModifiableInteger m = new ModifiableInteger(10);	
		assertEquals("10", m.toString());
	}


}
