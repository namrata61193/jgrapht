package org.jgrapht.alg.util;

import cucumber.api.java.en.Given;
 import cucumber.api.java.en.Then;
 import cucumber.api.java.en.When;
  
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.assertEquals;

 import java.util.*;

public class MoreDefinitions {

	TreeSet<String> set ;
        ArrayList<ArrayList<String>> sets;
        UnionFind<String> uf;

	@Given("I have created a set$")
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

        }

}
