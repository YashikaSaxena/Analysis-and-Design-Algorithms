
import java.util.*; 
import java.lang.*; 
import java.io.*; 
public class DijkstraAlgo {
	
	  
	  
	    // A utility function to find the vertex with minimum distance value, 
	    // from the set of vertices not yet included in shortest path tree 
	    static final int V = 5; 
	    int minDistance(int dist[], Boolean sptSet[]) 
	    { 
	        // Initialize min value 
	        int min = Integer.MAX_VALUE, min_index = -1; 
	  
	        for (int v = 0; v < V; v++) 
	            if (sptSet[v] == false && dist[v] <= min) { 
	                min = dist[v]; 
	                min_index = v; 
	            } 
	  
	        return min_index; 
	    } 
	  
	    // A utility function to print the constructed distance array 
	    void printSolution(int dist[], int n) 
	    { 
	        System.out.println("Vertex \t Distance from Source"); 
	        for (int i = 0; i < V; i++) 
	            System.out.println(i + " \t\t " + dist[i]); 
	    } 
	  
	    // Function that implements Dijkstra's single source shortest path 
	    // algorithm for a graph represented using adjacency matrix 
	    // representation 
	    void dijkstra(int graph[][], int src) 
	    { 
	        int dist[] = new int[V]; 
	        Boolean sptSet[] = new Boolean[V]; 
	  
	        // Initialize all distances as INFINITE and stpSet[] as false 
	        for (int i = 0; i < V; i++) { 
	            dist[i] = Integer.MAX_VALUE; 
	            sptSet[i] = false; 
	        } 
	  
	        // Distance of source vertex from itself is always 0 
	        dist[src] = 0; 
	  
	        // Find shortest path for all vertices 
	        for (int count = 0; count < V - 1; count++) { 
	             
	            int u = minDistance(dist, sptSet); 
	  
	           
	            sptSet[u] = true; 
	  
	            // Update dist value of the adjacent vertices of the 
	            // picked vertex. 
	            for (int v = 0; v < V; v++) 
	  
	                if (!sptSet[v] && graph[u][v] != 0 &&  
	                   dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
	                    dist[v] = dist[u] + graph[u][v]; 
	        } 
	  
	       
	        printSolution(dist, V); 
	    } 
	  
	    // Driver method 
	    public static void main(String[] args) 
	    { 
	       
	        int graph[][] = new int[][] { { 0, 3, 0, 0, 5}, 
	                                      { 0, 0, 8, 5, 3}, 
	                                      { 0, 0, 0, 0, 0}, 
	                                      { 0, 0, 2, 0, 0}, 
	                                      { 0, 0, 0, 4, 0}};
	                                      
	       DijkstraAlgo t = new DijkstraAlgo(); 
	        t.dijkstra(graph, 0); 
	    } 
	 
}
