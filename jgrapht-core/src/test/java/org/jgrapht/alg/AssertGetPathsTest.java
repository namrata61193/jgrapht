package org.jgrapht.alg;
import junit.framework.*;
import org.jgrapht.graph.*;
import java.util.*;
import org.jgrapht.*;

public class AssertGetPathsTest extends TestCase 
{
	public KShortestPaths init()
	{
		KShortestPathCompleteGraph6 graph = new KShortestPathCompleteGraph6();
		KShortestPaths paths = new KShortestPaths(graph, "vS", 3);

		return paths;

	}

	public void testNullEndVertex()
	{
		KShortestPaths paths = init();
		try {
			paths.assertGetPaths(null); 
		}
		catch (NullPointerException e) {
			assertEquals("endVertex is null", e.getMessage());
		}

	}

	public void testSameStartandEndVertex()
	{
		KShortestPaths paths = init();
		try {
			paths.assertGetPaths("vS"); 
		}
		catch (IllegalArgumentException e) {
			assertEquals("The end vertex is the same as the start vertex!", e.getMessage());
		}

	}

	public void testNonexistantEndVertex()
	{
		KShortestPaths paths = init();
		try {
			paths.assertGetPaths("aa"); 
		}
		catch (IllegalArgumentException e) {
			assertEquals("Graph must contain the end vertex!", e.getMessage());
		}

	}


	

}
