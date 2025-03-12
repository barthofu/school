from graph import Graph
from louvain import LouvainCommunityDetection

if __name__ == "__main__":
    # Example of usage

    # Create the graph
    my_graph = Graph()
    edges = [('A', 'B'), ('A', 'E'), ('B', 'C'), ('C', 'F'), ('C', 'D'), ('D', 'E'), ('D', 'F'), ('E', 'F')]

    for edge in edges:
        my_graph.add_edge(*edge)

    # Create an instance of Louvain
    louvain = LouvainCommunityDetection(my_graph)

    # Run the algorithm
    louvain.run()

    # Access the best-found partition
    best_partition = louvain.best_partition
    print(best_partition)