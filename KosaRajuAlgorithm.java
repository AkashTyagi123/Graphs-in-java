import java.util.*;
class Graph{
  private HashMap<Integer,ArrayList<Integer>> hm;
  private HashMap<Integer,ArrayList<Integer>> hmi;
  Graph(){
    hm = new HashMap<>();
    hmi = new HashMap<>();

  }
  void addEdgeInv(int u,int v,boolean isBidirectional){
    if(!hmi.containsKey(u))
      hmi.put(u,new ArrayList<>());
    if(!hmi.containsKey(v))
      hmi.put(v,new ArrayList<>());

    hmi.get(u).add(v);
    if(isBidirectional)
      hmi.get(v).add(u);
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
  private void invertGraph(){

    int v= hm.keySet().size();
    for(int i=0;i<v;i++){
      for(int adj:hm.get(i))
        addEdgeInv(adj,i,false);

    }

  }
  private void dfs(int src,boolean isVisited[]){
    isVisited[src]=true;
    System.out.print(src+"->");
    for(int adj:hmi.get(src)){
      if(!isVisited[adj])
        dfs(adj,isVisited);
    }
  }
  private void dfs(int src,boolean isVisited[],Stack<Integer> st){
    isVisited[src]=true;
    for(int adj:hm.get(src)){
      if(!isVisited[adj])
        dfs(adj,isVisited,st);
    }
    st.push(src);
  }
  void KosaRajuHelper(){
    int v = hm.keySet().size();
    boolean isVisited[]=new boolean[v];
    Stack<Integer> st = new Stack<>();
  //Populate the stack first using the DFS
    for(int i=0;i<v;i++){
        if(!isVisited[i]){
          dfs(i,isVisited,st);
        }
    }

    //Invert the graph
    invertGraph();

    //Now again pop out from stack
    Arrays.fill(isVisited,false);
    while(!st.isEmpty()){
      int ele = st.pop();
      if(!isVisited[ele])
        {
          dfs(ele,isVisited);
        }
      System.out.println();
    }

  }
}
class KosaRaju{
  public static void main(String[] args) {
    Graph g = new Graph();
    g.addEdge(0,1,false);
    g.addEdge(1,2,false);
    g.addEdge(2,3,false);
    g.addEdge(3,0,false);
    g.addEdge(5,4,false);
    g.addEdge(4,6,false);
    g.addEdge(6,5,false);
    g.addEdge(7,8,false);
    g.addEdge(8,7,false);
    g.addEdge(8,9,false);

    g.KosaRajuHelper();

  }
}
