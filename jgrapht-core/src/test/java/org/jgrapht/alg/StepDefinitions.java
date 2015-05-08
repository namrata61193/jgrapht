package org.jgrapht.alg;

import java.util.*;

import org.jgrapht.*;
import org.jgrapht.graph.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.assertEquals;

import org.jgrapht.generate.*;

public class StepDefinitions extends ShortestPathTestCase{

	KShortestPathCompleteGraph6 graph ;
	KShortestPaths paths ; 
	Graph<String, DefaultWeightedEdge> bellmanfordGraph;
        Graph<String, DefaultWeightedEdge> g ;
	BellmanFordShortestPath<String, DefaultWeightedEdge> path;
	List path2;
	SimpleWeightedGraph simpleWeightedGraph ;

        Object sourceVertex ;
        KShortestPaths ksp ;

        Object targetVertex ;

	UndirectedGraph<Object, DefaultEdge> completeGraph;
	CompleteGraphGenerator<Object, DefaultEdge> completeGenerator;
	UndirectedGraph<Object, DefaultEdge> linearGraph;
	LinearGraphGenerator<Object, DefaultEdge> linearGenerator;

	@Override
    protected List findPathBetween(
        Graph<String, DefaultWeightedEdge> g,
        String src,
        String dest)
    {
        return BellmanFordShortestPath.findPathBetween(g, src, dest);
    }

		


	@Given("^I have created a graph$")
	public void I_have_a_graph(){
		graph =	 new KShortestPathCompleteGraph6();
		bellmanfordGraph =  create();	
		g = createWithBias(true);
			
	}

	@When("^I initialise the paths$")
	public void T_type_hello_world(){
		
		paths = new KShortestPaths(graph , "vS" , 3);
	}

	@Then("^the end vertex is null$")
	public void I_see_hello_world(){

		try {			
			paths.assertGetPaths(null); 		
		}
		catch (NullPointerException e)
 		{		
			assertEquals("endVertex is null", e.getMessage());	
		}	
	
	}

	@Then("^the start and end vertex are the same$")
	public void the_start_and_end_vertex_are_the_same(){

		try {			
			paths.assertGetPaths("vS"); 		
		}
		catch (IllegalArgumentException e) {			
			assertEquals("The end vertex is the same as the start vertex!", e.getMessage());		
		}
	}
	
	@Then("^the end vertex does not exist$")
	public void the_end_vertex_does_not_exist(){
	
		try {			
			paths.assertGetPaths("aa"); 		
		} 
		catch (IllegalArgumentException e) {			
			assertEquals("Graph must contain the end vertex!", 
				e.getMessage());		
		}
	}		

/*	@Given("I have created a set$")
	public void create_set(){
		set = new TreeSet<String>();
		String [] strs = {"aaa", "bbb", "ccc", "ddd", "eee"};
		sets = new ArrayList<ArrayList<String>>();
		
		for(String str: strs){
			set.add(str);
			sets.add(new ArrayList<String>());
			sets.get(sets.size() - 1).add(str);
		}

		uf = new UnionFind<String>(set);
	}

	@When("^I populate the union with strings$")
	public void populate_union(){
		uf.union("aaa" , "bbb");
	
	}

	@Then("^I should get an exception for an invalid key$")
	public void invalid_key_check(){
		String element = "";
		try{
			element = uf.find("xxx");
		}
		catch(IllegalArgumentException e){
			assertEquals("elements must be contained in given set" , e.getMessage());
	
		}
		
	}*/

	@When("^I initialise a new set of paths$")
	public void new_path_set(){
		paths = new KShortestPaths(graph , "vS" , 3 , 3);
	}

	@Then("^I get an exception for a negative input$")
	public void negative_input(){
		try{
			paths = new KShortestPaths(graph , "vS" , -3 , 3);
		}
		catch(NullPointerException e)
		{
			assertEquals("nPaths is negative or 0", e.getMessage());
		}
	}

	@When("^I have a constraint of (\\d+) on the number of hops$")
	public void constraint_hops(int constraint){
		if(constraint == 0){
		path = new BellmanFordShortestPath<String, DefaultWeightedEdge>(bellmanfordGraph, V3);	}
		else{	
		path = new BellmanFordShortestPath<String, DefaultWeightedEdge>(bellmanfordGraph, V3, constraint);	}	
	}

	@Then("^I should have a path length of (\\d+)$")
	public void find_path_length(int distance){
		if(distance == 100) {
			double answer = Double.POSITIVE_INFINITY;
        		assertEquals(answer, path.getCost(V5) , 0);
		}
		else{
        		assertEquals(distance, path.getCost(V5), 0);
		}
	}

	@When("^I try to find the path between 2 vertices$")
	public void findPathbetween(){

		path2 = findPathBetween(g, V1, V4);
	}

	@Then("^my path should be as expected$")
	public void expectPath(){
		 assertEquals(Arrays.asList(
                new DefaultEdge[] {
                    e13,
                    e34
                }), path2);
	}

	@Given("^I have created a simple KSP example graph and a source and target vertex$")
	public void I_have_created_simple_KSP(){

		simpleWeightedGraph = new KSPExampleGraph();
		sourceVertex = "S";
		targetVertex = "T";
		
	}

	@When("^I try to find (\\d+) paths between the source and target vertex$")
	public void find_paths(int paths){

	      ksp = new KShortestPaths(simpleWeightedGraph, sourceVertex, paths);
	}

	@Then("^the number of paths obtained should be (\\d+)$")
	public void assert_paths(int paths){

		assertEquals(paths, ksp.getPaths(targetVertex).size());
	}

	@Given("^I have initialised a graph$")
	public void create_new_graph(){

		completeGraph = new SimpleGraph<Object, DefaultEdge>(DefaultEdge.class);
		linearGraph = new SimpleGraph<Object, DefaultEdge>(DefaultEdge.class);

	}
	
	@When("^I use a generator to generate a complete graph of size (\\d+)$")
	public void do_generator(int num){
		completeGenerator =
            new CompleteGraphGenerator<Object, DefaultEdge>(
                num);
        completeGenerator.generateGraph(
            completeGraph,
            new ClassBasedVertexFactory<Object>(Object.class),
            null);

	}

	@When("^I use a generator to generate a linear graph$")
	public void create_linear_graph(){

		linearGenerator =
            new LinearGraphGenerator<Object, DefaultEdge>(
                50);

		linearGenerator.generateGraph(
            linearGraph,
            new ClassBasedVertexFactory<Object>(Object.class),
            null);
	}

	@Then("^the chromatic number of the complete graph must be (\\d+)$")
	public void check_chromatic_number_complete(int num){

		assertEquals(
            num,
            ChromaticNumber.findGreedyChromaticNumber(completeGraph));
	}

	@Then("^the chromatic number of the linear graph must be (\\d+)$")
        public void check_chromatic_number_linear(int num){

                assertEquals(
            num,
            ChromaticNumber.findGreedyChromaticNumber(linearGraph));
        }

	
}
