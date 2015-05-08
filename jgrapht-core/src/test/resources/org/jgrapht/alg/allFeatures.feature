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

  Scenario Outline: BellManFord Algorithm
	Given I have created a graph
	When I have a constraint of <hops> on the number of hops
	Then I should have a path length of <number of paths>

	Examples:
	| hops | number of paths |
	| 0    |   15            |
	| 2    |   25            |
	| 1    |  100            |
	| 3    |  25             |

  Scenario: Testing negative edges with Bellman Ford
	Given I have created a graph
	When I try to find the path between 2 vertices
	Then my path should be as expected

  Scenario Outline: Testing K Shortest Paths
	Given I have created a simple KSP example graph and a source and target vertex
	When I try to find <constraint> paths between the source and target vertex
	Then the number of paths obtained should be <number of paths>

	Examples:
	  | constraint | number of paths|
          |    5       |   3            |
	  |    4       |   3            |
	  |    3       |   3            |
	  |    2       |   2            |

  Scenario Outline: Testing Chromatic Number of a complete graph
	Given I have initialised a graph
	When I use a generator to generate a complete graph of size <number of nodes>
	Then the chromatic number of the complete graph must be <chromatic number>

	Examples:
	| number of nodes | chromatic number |
	|  7              |     7            |
	|  6              |     6            |
	|  5              |     5            |

  Scenario: Testing Chromatic Number of a linear graph
        Given I have initialised a graph
        When I use a generator to generate a linear graph 
        Then the chromatic number of the linear graph must be 2

