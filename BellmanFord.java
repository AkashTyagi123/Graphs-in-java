import java.util.*;

class BellmanFord{

  void bellmanFunction(int graph[][],int src){
    int vertex = graph.length;
    int dist[]=new int[vertex];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[src]=0;
    //It works on the principle that the shortest path always have |V|-1 edges
    for(int i=0;i<vertex-1;i++){
         if(dist[i]==Integer.MAX_VALUE)
          continue;
        for(int j=0;j<vertex;j++){
          for(int k=0;k<vertex;k++){
            if(graph[j][k]!=0){
               dist[k]=Math.min(dist[k],dist[j]+graph[j][k]);
            }
          }
        }
    }
    for(int k=0;k<vertex;k++){
      System.out.println(k+"-> "+dist[k]);
    }

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

      BellmanFord b = new BellmanFord();
      b.bellmanFunction(graph,0);



  }
}
