package org.jgrapht.alg;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.assertEquals;

import java.util.*;

public class StepDefinitions {

	KShortestPathCompleteGraph6 graph ;
	KShortestPaths paths ; 
//	TreeSet<String> set ;
//	ArrayList<ArrayList<String>> sets;
//	UnionFind<String> uf;	
	@Given("^I have created a graph$")
	public void I_have_a_graph(){
		graph =	 new KShortestPathCompleteGraph6();
			
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



	
}
