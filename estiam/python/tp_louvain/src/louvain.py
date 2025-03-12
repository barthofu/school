"""
This file contains the implementation of the Louvain algorithm for community detection in an undirected graph.
"""

from graph import Graph

class LouvainCommunityDetection:

    def __init__(self, graph: Graph):
        self.__graph = graph
        self.__current_partition = { node: i for i, node in enumerate(graph.nodes()) }
        self.__best_partition = None

    def run(self):

        while True:
            improvement = False

            # Move Phase
            for node in self.__graph.nodes():
                best_community = self.__get_best_community(node)
                current_community = self.__current_partition[node]

                if best_community != current_community:
                    self.__current_partition[node] = best_community
                    improvement = True

            # Aggregation Phase
            if improvement:
                self.__aggregate_communities()
            else:
                break

        # Update the best-found partition
        self.__best_partition = self.__current_partition

    def __get_best_community(self, node):
        current_community = self.__current_partition[node]
        neighbors = self.__graph.neighbors_of(node)

        max_modularity_gain = 0
        best_community = current_community

        for neighbor in neighbors:
            neighbor_community = self.__current_partition[neighbor]
            modularity_gain = self.__calculate_modularity_gain(node, neighbor)

            if modularity_gain > max_modularity_gain:
                max_modularity_gain = modularity_gain
                best_community = neighbor_community

        return best_community

    def __calculate_modularity_gain(self, node, neighbor):

        total_degree = sum(len(self.__graph.neighbors_of(node)) for node in self.__graph.nodes())
        intersect_degree = len(set(self.__graph.neighbors_of(node)) & set(self.__graph.neighbors_of(neighbor)))
        modularity = (1 / total_degree) - (intersect_degree / total_degree)
        return modularity

    def __aggregate_communities(self):
        # Reassign communities
        communities = {}
        for node, community in self.__current_partition.items():
            if community not in communities:
                communities[community] = [node]
            else:
                communities[community].append(node)

        # Update the partition
        new_partition = {}
        for new_community, nodes in communities.items():
            for node in nodes:
                new_partition[node] = new_community

        self.__current_partition = new_partition

    @property
    def best_partition(self):
        return self.__best_partition
