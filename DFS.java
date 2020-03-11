import java.util.*;
class DFS{
	public static void main(String [] args){
       Graph<Integer> g=new Graph<>();
        g.addEdge(0, 1,true); 
        g.addEdge(0, 2,true); 
        g.addEdge(1, 2,true); 
        g.addEdge(2, 0,true); 
        g.addEdge(2, 3,true); 
        g.addEdge(3, 3,true);
              //g.display();
       //g.bfs(2);
       g.dfs(2);

	}
}
class Graph<T>{
	HashMap<T,ArrayList<T>> hm=new HashMap<>();
		void addEdge(T v1,T v2,boolean isBidirectional){
        if(hm.containsKey(v1)==false)
        	hm.put(v1,new ArrayList<>());
        if(hm.containsKey(v2)==false)
        	hm.put(v2,new ArrayList<>());
        hm.get(v1).add(v2);
        if(isBidirectional==true)
        	hm.get(v2).add(v1);
	}	

	// void display(){
	// 	Set<T> hs=hm.keySet();
	// 	for(T k:hs){
	// 		System.out.println(k+"-->"+hm.get(k));
	// 	}
	// }

	void bfs(T src){
      HashMap<T,Boolean> isVisited=new HashMap<>();
      //Initialising the isVisited map as false
      Set<T> hs=hm.keySet();
	  for(T k:hs)
	  {
		isVisited.put(k,false);
	  }
      isVisited.put(src,true);
      
      Queue<T> q=new LinkedList<>();
      q.add(src);
      while(!q.isEmpty()){
          	T ele=q.poll();
          	System.out.println(ele);
            for(T k:hm.get(ele)){
          	
          		if(isVisited.get(k)==false){
              		isVisited.put(k,true);
          	  		q.add(k);
          		}
          	}
      	
      	}



	}
  void dfsHelper(T node,HashMap<T,Boolean> isVisited){
    isVisited.put(node,true);
    System.out.println(node);
    for(T k:hm.get(node)){
      if(isVisited.get(k)==false)
        dfsHelper(k,isVisited);
    }
  }
  void dfs(T src){
    HashMap<T,Boolean> isVisited=new HashMap<>();
    Set<T> hs=hm.keySet();
    for(T k:hs){
    
      isVisited.put(k,false);
    }
    dfsHelper(src,isVisited);
  }

}