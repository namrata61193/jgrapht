/* ==========================================
 * JGraphT : a free Java graph-theory library
 * ==========================================
 *
 * Project Info:  http://jgrapht.sourceforge.net/
 * Project Creator:  Barak Naveh (http://sourceforge.net/users/barak_naveh)
 *
 * (C) Copyright 2003-2008, by Barak Naveh and Contributors.
 *
 * This program and the accompanying materials are dual-licensed under
 * either
 *
 * (a) the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation, or (at your option) any
 * later version.
 *
 * or (per the licensee's choosing)
 *
 * (b) the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation.
 */
/* ------------------------------
 * DijkstraShortestPathTest.java
 * ------------------------------
 * (C) Copyright 2003-2008, by John V. Sichi and Contributors.
 *
 * Original Author:  John V. Sichi
 * Contributor(s):   -
 *
 * $Id$
 *
 * Changes
 * -------
 * 03-Sept-2003 : Initial revision (JVS);
 * 14-Jan-2006 : Factored out ShortestPathTestCase (JVS);
 *
 */
package org.jgrapht.alg;

import java.util.*;

import org.jgrapht.*;
import org.jgrapht.graph.*;


/**
 * .
 *
 * @author John V. Sichi
 */
public class DijkstraShortestPathTest
    extends ShortestPathTestCase
{
    //~ Methods ----------------------------------------------------------------

    /**
     * .
     */
    /*
    public DijkstraShortestPath init()
    {
	Graph<String, DefaultWeightedEdge> g = create();
	DijkstraShortestPath<String, DefaultWeightedEdge> path = 
		new DijkstraShortestPath<String, DefaultWeightedEdge>(g, V3, V4, Double.POSITIVE_INFINITY);
	return path;
    }*/

    public void testConstructor()
    {
        DijkstraShortestPath<String, DefaultWeightedEdge> path;
        Graph<String, DefaultWeightedEdge> g = create();

        path =
            new DijkstraShortestPath<String, DefaultWeightedEdge>(
                g,
                V3,
                V4,
                Double.POSITIVE_INFINITY);
        assertEquals(
            Arrays.asList(
                new DefaultEdge[] {
                    e13,
                    e12,
                    e24
                }),
            path.getPathEdgeList());
        assertEquals(10.0, path.getPathLength(), 0);

        path =
            new DijkstraShortestPath<String, DefaultWeightedEdge>(
                g,
                V3,
                V4,
                7);
        assertNull(path.getPathEdgeList());
        assertEquals(Double.POSITIVE_INFINITY, path.getPathLength(), 0);
    }

    @Override
    protected List findPathBetween(
        Graph<String, DefaultWeightedEdge> g,
        String src,
        String dest)
    {
        return DijkstraShortestPath.findPathBetween(g, src, dest);
    }

    public void testNoStartVertex()
    {
	DijkstraShortestPath<String, DefaultWeightedEdge> path;
	try{	
		Graph<String, DefaultWeightedEdge> g = create();
                 path = new DijkstraShortestPath<String, DefaultWeightedEdge>(g, null, V3, Double.POSITIVE_INFINITY);	

		fail("Exception not thrown");	
	}

	catch (Exception e){

                assertEquals("graph must contain the start vertex", e.getMessage());
		
	}
    }

    
    public void testDoubleRadius()
    {
	DijkstraShortestPath<String, DefaultWeightedEdge> path;
	try{	
		Graph<String, DefaultWeightedEdge> g = create();
                 path = new DijkstraShortestPath<String, DefaultWeightedEdge>(g, V4, V3, 1.78d);	

		fail("Exception not thrown");	
	}

	catch (Exception e){

                assertEquals("radius must be of type float", e.getMessage());
		
	}
    }



    public void testInvalidGraph()
    {
	DijkstraShortestPath<String, DefaultWeightedEdge> path;
	try{	
                 path = new DijkstraShortestPath<String, DefaultWeightedEdge>(null, V4, V3, Double.POSITIVE_INFINITY);	

		fail("Exception not thrown");	
	}

	catch (Exception e){

                assertEquals("“graph must not be empty”", e.getMessage());
		
	}
    }

    

	

    public void testInvalidEndVertexConstructor()
    {
        try {
         	Graph<String, DefaultWeightedEdge> g = create();
		DijkstraShortestPath<String, DefaultWeightedEdge> path = 
			new DijkstraShortestPath<String, DefaultWeightedEdge>(g, V3, "xy", Double.POSITIVE_INFINITY);
        }
        catch (IllegalArgumentException e){
                assertEquals("graph must contain the end vertex", e.getMessage());
        }
     }

     public void testNullEndVertexConstructor()
     {
	try {
         	Graph<String, DefaultWeightedEdge> g = create();
		DijkstraShortestPath<String, DefaultWeightedEdge> path = 
			new DijkstraShortestPath<String, DefaultWeightedEdge>(g, V3, null, Double.POSITIVE_INFINITY);
        }
        catch (IllegalArgumentException e){
                assertEquals("graph must contain the end vertex", e.getMessage());
        }
     }


}

// End DijkstraShortestPathTest.java
