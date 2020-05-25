//Single source shortest path using BFS traversals
import java.util.*;
import java.io.*;
class Graph{
  private HashMap<Integer,ArrayList<Integer>> graph;
  int nodes;
  Graph(int n){
       graph = new HashMap<>();
       nodes = n;
  }

  void addEdge(int u,int v,boolean isBidirectional){
    if(!graph.containsKey(u))
      graph.put(u,new ArrayList<>());

      if(!graph.containsKey(v))
        graph.put(v,new ArrayList<>());

      graph.get(u).add(v);
      if(isBidirectional)
        graph.get(v).add(u);
  }

  int getShortestPath(int src , int dest){

    boolean isVisited[] = new boolean[nodes+1];
    
    int dist[] = new int[nodes+1];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(src);
    isVisited[src] = true;
    while(!queue.isEmpty()){
      int ele = queue.poll();

      for(int adj:graph.get(ele)){
          if(isVisited[adj]==false){
            queue.add(adj);
            isVisited[adj]=true;
            dist[adj]+=(dist[ele]+1);
          }
      }
    }
    return dist[dest];
  }

}
class SingleSourceShortestPath{
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int vertices = Integer.parseInt(br.readLine());
      int edges = Integer.parseInt(br.readLine());
      Graph g = new Graph(vertices);
      while(edges-- >0){
        String in[] = br.readLine().split(" ");
        int u = Integer.parseInt(in[0]);
        int v = Integer.parseInt(in[1]);
        g.addEdge(u,v,true);
      }
      int source = Integer.parseInt(br.readLine());
      int destination = Integer.parseInt(br.readLine());
      int dist = g.getShortestPath(source,destination);
      System.out.println(dist);

  }
}
