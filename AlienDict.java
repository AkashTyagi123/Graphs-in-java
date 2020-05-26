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
    int v = hm.keySet().size();
    int inDegree[] = new int[v];
    for(int vertex:hm.keySet()){
      for(int adj:hm.get(vertex))
        inDegree[adj]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for(int i=0;i<v;i++){
      if(inDegree[i]==0)
        queue.add(i);
    }
    String topOrder="";
    while(!queue.isEmpty()){
      int ele = queue.poll();
      char ch= (char)(ele +'a');
      topOrder=topOrder+ch+" ";
      for(int adj:hm.get(ele)){
        inDegree[adj]--;
        if(inDegree[adj]==0)
          queue.add(adj);
      }

    }
    System.out.println(topOrder);


    }
}
class AlienDict{
  public static void main(String[] args) {
      String words[]={"baa", "abcd", "abca", "cab", "cad"};
      Graph g = new Graph();
      for(int i=0;i<words.length-1;i++){
        String word1 = words[i];
        String word2 = words[i+1];
        for(int j=0;j<Math.min(word1.length(),word2.length());j++){
          if(word1.charAt(j)!=word2.charAt(j)){
            g.addEdge(word1.charAt(j)-'a',word2.charAt(j)-'a',false);
            break;
          }
        }
      }
      g.topologicalSort();

  }
}
