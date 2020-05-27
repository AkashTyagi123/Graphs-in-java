/*
Bridge:- A bridge is an edge which when removed makes the
the graph disconnected or increase the number of disconnected
components.
*/
import java.util.*;
class Timer{
  int timer;
  Timer(){
    timer =0;
  }
}
class Graph{
  private HashMap<Integer,ArrayList<Integer>> hm;
  Graph(){
    hm = new HashMap<>();
  }
  void addEdge(int u,int v,boolean isBidirectional){
    if(!hm.containsKey(u))
      hm.put(u,new ArrayList<>());
    if(!hm.containsKey(v))
      hm.put(v,new ArrayList<>());
    hm.get(u).add(v);
    if(isBidirectional)
      hm.get(v).add(u);
  }
  private  void bridgeHelper(int node,int par,boolean isVisited[],int in[],int low[],Timer t){
        isVisited[node]=true;
        in[node] = t.timer;
        low[node]=t.timer;
        t.timer++;
        for(int child:hm.get(node)){
          if(child == par)
            continue;
          if(isVisited[child]==true){
            //node to child is a back edge
            low[node] =Math.min(low[node],in[child]);
          }
          else{
            //node to child i a forward edge
             bridgeHelper(child,node,isVisited,in,low,t);
             if(in[node]<low[child])
              System.out.println(node+"->"+child+" is a back edge");
            low[node] =Math.min(low[node],low[child]);
          }

        }
  }
  void bridge(){

    int nodes = hm.keySet().size();
    boolean isVisited[]=new boolean[nodes];
    int in[]=new int[nodes];
    int low[]=new int[nodes];
    Timer t = new Timer();
    bridgeHelper(0,-1,isVisited,in,low,t);
  }
}
class Bridges{
  public static void main(String[] args) {
    Graph g1 = new Graph();
      g1.addEdge(0,1,true);
      g1.addEdge(1,2,true);
      g1.addEdge(2,0,true);
      g1.addEdge(1,3,true);
      g1.addEdge(1,4,true);
      g1.addEdge(1,6,true);
      g1.addEdge(3,5,true);
      g1.addEdge(4,5,true);
      g1.bridge();
  }

}
