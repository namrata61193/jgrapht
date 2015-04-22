Feature: Graph

  Scenario: A Null Graph Test
	Given I have created a graph
	When I initialise the paths
	Then the end vertex is null

  Scenario: End vertex same as Start Vertex
	Given I have created a graph
	When I initialise the paths
	Then the start and end vertex are the same

  Scenario: End vertex does not exist
	Given I have created a graph
	When I initialise the paths
	Then the end vertex does not exist

  Scenario: Searching for Invalid Key
	Given I have created a set 
	When I populate the union with strings 
	Then I should get an exception for an invalid key

  Scenario: Negative Path 
	Given I have created a graph
	When I initialise a new set of paths
	Then I get an exception for a negative input
