"""
This file contains the implementation of a basic graph with nodes and edges.
"""

class Graph:
    def __init__(self):
        self.__graph = {}

    def add_node(self, node: str):
        if node not in self.nodes():
            self.__graph[node] = []

    def add_edge(self, node1, node2):
        # First create the nodes if they don't exist
        self.add_node(node1)
        self.add_node(node2)
        # Then add the edge 
        self.__graph[node1].append(node2)
        self.__graph[node2].append(node1)

    def nodes(self):
        return list(self.__graph.keys())
    
    def edges(self):
        edge_set = set()
        for node, neighbors in self.__graph.items():
            for neighbor in neighbors:
                edge_set.add(tuple(sorted((node, neighbor))))
        return list(edge_set)
    
    def neighbors_of(self, node: str):
        return self.__graph.get(node, [])
    
    def are_neighbors(self, node1: str, node2: str):
        return node2 in self.neighbors_of(node1)
    
    def len(self) -> int:
        return len(self.nodes)