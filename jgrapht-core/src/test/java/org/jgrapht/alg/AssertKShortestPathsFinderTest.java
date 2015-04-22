package org.jgrapht.alg;
import junit.framework.*;
import org.jgrapht.graph.*;
import java.util.*;
import org.jgrapht.*;

public class AssertKShortestPathsFinderTest extends TestCase 
{
	KShortestPathCompleteGraph6 graph;

	public void init()
	{
		graph = new KShortestPathCompleteGraph6();
	}

	public void testNullGraph()
	{
		try {
			KShortestPaths paths = new KShortestPaths(null, "vS", 3 ,3);
		}
		catch (NullPointerException e) {
			assertEquals("graph is null", e.getMessage());
		}
	}

	public void testNullStartVertex()
	{
		try {
			init();
			KShortestPaths paths = new KShortestPaths(graph, null, 3 ,3);
		}
		catch (NullPointerException e) {
			assertEquals("startVertex is null", e.getMessage());
		}
	}

	public void testNegativeNPaths()
	{
		try {
			init();
			KShortestPaths paths = new KShortestPaths(graph, "vS", -3 ,3);
		}
		catch (NullPointerException e) {
			assertEquals("nPaths is negative or 0", e.getMessage());
		}
	}

	public void testNegativeNMaxHops()
	{
		try {
			init();
			KShortestPaths paths = new KShortestPaths(graph, "vS", 3 ,-3);
		}
		catch (NullPointerException e) {
			assertEquals("nMaxHops is negative or 0", e.getMessage());
		}
	}
}
