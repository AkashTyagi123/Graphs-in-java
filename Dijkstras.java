/*
Dijkstra algorithm does not work for negative weight cycle. To do the same stuff in a graph with negative weight cycle we use 
Bellman ford Algorithm.
*/
import java.util.*;

class Dijkstra{
  private int getMinimum(HashSet<Integer> isVisited,int dist[],int nodes){
    int min=Integer.MAX_VALUE;
    int minIndex=-1;
    for(int node = 0;node <nodes;node++){
      if(!isVisited.contains(node)){
        if(dist[node]<=min){
          min=dist[node];
          minIndex=node;
        }
      }
    }
    return minIndex;
  }
  private void getShortestPath(int graph[][],int src){
    HashSet<Integer> visited = new HashSet<>();
    int n = graph.length;
    int dist[] = new int[n];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[src]=0;
    while(visited.size()<n){
      int u = getMinimum(visited,dist,n);
      visited.add(u);
      for(int i=0;i<n;i++){
        if(graph[u][i]!=0){
          dist[i]=Math.min(dist[i],dist[u]+graph[u][i]);
        }
      }
    }
    //Printing the shortest distance between nodes.
    for(int k:dist)
      System.out.println(k);

  }
  public static void main(String[] args) {
    int graph[][]=new int[][]{ { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                             { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                             { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                             { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                             { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                             { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                             { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                             { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                             { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
    Dijkstra obj = new Dijkstra();
    obj.getShortestPath(graph,0);
  }
}
