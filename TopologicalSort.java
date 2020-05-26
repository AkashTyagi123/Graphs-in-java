import java.util.*;
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
  void topologicalSort(){
    int vertices = hm.keySet().size();
    int inDegree[]=new int[vertices];
    for(int v:hm.keySet()){
      for(int adj:hm.get(v))
        inDegree[adj]++;
    }
    int count=0;
    Queue<Integer> queue = new LinkedList<>();
    ArrayList<Integer> topOrder = new ArrayList<>();

    for(int i=0;i<vertices;i++){
      if(inDegree[i]==0)
        queue.add(i);
    }
    while(!queue.isEmpty()){
      int u = queue.poll();
      topOrder.add(u);
      for(int x:hm.get(u)){
        inDegree[x]--;
        if(inDegree[x]==0)
          queue.add(x);
      }
    }
    for(int ele:topOrder)
      System.out.println(ele+"->");
  }
}
class TopologicalSort{
  public static void main(String[] args) {
    Graph g = new Graph();
    g.addEdge(5,2,false);
    g.addEdge(5,0,false);
    g.addEdge(4,0,false);
    g.addEdge(4,1,false);
    g.addEdge(2,3,false);
    g.addEdge(3,1,false);
    g.topologicalSort();

  }
}
