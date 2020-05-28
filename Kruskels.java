import java.util.*;
//Custom class to show a edge
class Edges{
  int src;
  int dest;
  int weight;
}
//Comparator to compare edge array accordignt to weight
class EdgeComparator implements Comparator<Edges>{
  public int compare(Edges e1,Edges e2){
    return e1.weight-e2.weight;
  }
}
//classdepicting graph
class Graph{
   Edges edge[];
  private int V;
  private  int E;
  Graph(int V,int E){
    this.V = V;
    this.E= E;
    edge = new Edges[E];
    for(int i=0;i<E;i++){
      edge[i]=new Edges();
    }
  }

  int root(int arr[],int i){

    while(arr[i]!=i){

      arr[i] = arr[arr[i]];
      i=arr[i];
    }
    return i;
  }
  void union(int a,int b,int arr[],int size[]){
    int root_a = root(arr,a);
    int root_b = root(arr,b);
    if(size[root_a]<size[root_b]){
      arr[root_a] = arr[root_b];
      size[root_b] +=size[root_a];

    }
    else{
       arr[root_b]=arr[root_a];
       size[root_a]+=size[root_b];
    }
  }
  public void KruskelsMST(){
    //First of all sort the edges according to the weight
    Arrays.sort(edge,new EdgeComparator());
    int i=0;
    int countEdgeMst=0;
    int MSTCost=0;
    int arr[]=new int[V];
    for(int j=0;j<V;j++){
      arr[j]=j;
    }
    int size[]=new int[V];
    Arrays.fill(size,1);
    HashSet<Edges> hs = new HashSet<>();
    while(i<E){

      Edges e = edge[i];
      int u = e.src;
      int v = e.dest;
      if(root(arr,u)!=root(arr,v)){
        MSTCost+=e.weight;
        countEdgeMst++;
        hs.add(e);
        union(u,v,arr,size);
      }
      i++;

    }
    System.out.println("MST formed with Weight:- "+MSTCost);
    for(Edges e1:hs){
      System.out.println(e1.src+"->"+e1.dest+"="+e1.weight);
    }
  }
}
class Kruskels{
  public static void main(String[] args) {
      int V=4;
      int E=5;
      Graph graph = new Graph(V,E);
      // add edge 0-1
        //System.out.println(graph.E);;
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskelsMST();
  }
}
