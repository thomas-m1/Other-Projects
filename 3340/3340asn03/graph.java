
public class graph {
	public int[][] edge;
	
	//creates graph and sets edges. set each edge weight to -1 to represent infinity
	public graph(int numVertices){
		edge = new int[numVertices][numVertices];// sets edge
		for(int u = 0; u < numVertices; u++) {
			for(int v = 0; v < numVertices; v++){
				edge[u][v] = -1;
			}
		}
	}
	
	//gets weight of edge for vertices
	public int getWeight (int u, int v) {
		return edge[u][v];
	}
	
	//sets weight of edge for vertices
	public void setWeight (int u, int v, int updateWeight) {
		edge[u][v] = updateWeight;
	}
}