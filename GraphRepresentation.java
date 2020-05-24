import java.util.*;
import java.io.*;
/* Graph can be represented in two ways:-
1.Adjency Matrix:
It is good to determine whether a edge exist between two nodes
Space complexity is O(v^2)
To know if two nodes are connected:O(1)
To know the neighbors of a node O(V)
This type of representation is good for dense graph. For sparse graph we waste a lot of space
Adding a new vertex takes O(1) time
2.Adjency List
It is good in term of space its space complexity is O(V+E)
to know if two node are connected O(V)
to know the neighbors the complexit is O(v)
adding a new node take O(V).
*/
class Graph{
  private HashMap<Integer,ArrayList<Integer>> hm;
  Graph(){
    hm=new HashMap<>();
  }
  public void addEdge(int u,int v,boolean isBidrectional){
          if(hm.containsKey(u)==false)
          hm.put(u,new ArrayList<Integer>());
          if(hm.containsKey(v)==false)
          hm.put(v,new ArrayList<Integer>());

          hm.get(u).add(v);
          if(isBidrectional==true){
            hm.get(v).add(u);
          }

  }
  public void displayGraph(){
    for(int key:hm.keySet()){
      ArrayList<Integer> arr=hm.get(key);
      System.out.print(key+"->");
      for(int ele:arr){
        System.out.print(ele+" ");
      }
      System.out.println();
    }
  }
}
class GraphRepresentation{
  public static void main(String[] args)throws IOException {
    //A graph is represented by a set of Pair (u,v)
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    int vertices=Integer.parseInt(br.readLine());
    int edges=Integer.parseInt(br.readLine());
    Graph graph = new Graph();
    //adjency matrix representation
    int matrix[][]=new int[vertices+1][vertices+1];

    //Adjency List representation
    while(edges-->0){
      String inp[]=br.readLine().split(" ");
      int u=Integer.parseInt(inp[0]);
      int v=Integer.parseInt(inp[1]);
      matrix[u][v]=1; //putting the element in the adjency matrix
      graph.addEdge(u,v,false);


    }
    //Representing the adjency matrix
    for(int i=1;i<=vertices;i++){
      for(int j=1;j<=vertices;j++){
        System.out.print(matrix[i][j]+" ");
      }
      System.out.println();
    }
    graph.displayGraph();


  }
}
