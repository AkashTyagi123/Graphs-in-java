/*
Code for detecting cycle in a directed graph using DFS

*/
import java.util.*;
import java.io.*;
class Graph{
  HashMap<Integer,ArrayList<Integer>> g;
  HashMap<Integer,Boolean> isVisited;
  Graph(){
    g=new HashMap<>();
    isVisited = new HashMap<>();
  }
  void addEdge(int u,int v,boolean isBidrectional){
    if(g.containsKey(u)==false){
      g.put(u,new ArrayList<>());
      isVisited.put(u,false);
    }
    if(g.containsKey(v)==false){
      g.put(v,new ArrayList<>());
      isVisited.put(v,false);
    }
    g.get(u).add(v);
    if(isBidrectional==true)
      g.get(v).add(u);

  }
  private boolean cycleDetectionHelper(int src){
    if(isVisited.get(src)==true){
      return true;
    }
    isVisited.put(src,true);
    boolean flag=false;
    for(int k:g.get(src)){
        flag = flag || cycleDetectionHelper(k);
        isVisited.put(k,false);
      }
    return flag;

  }
  boolean detectCycleInGraph(){
    return cycleDetectionHelper(1);
  }

}
class CycleDetectionDirectedGraph{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int vertices = Integer.parseInt(br.readLine());
    int edges = Integer.parseInt(br.readLine());
    Graph graph = new Graph();
    while(edges-->0){
      String in[]=br.readLine().split(" ");
      int u = Integer.parseInt(in[0]);
      int v = Integer.parseInt(in[1]);
      graph.addEdge(u,v,false);
    }
    boolean cyclePresent = false;
   cyclePresent = graph.detectCycleInGraph();
   if(cyclePresent)
   System.out.println("YES");
   else
   System.out.println("NO");
  }
}
