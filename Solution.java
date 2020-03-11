import java.util.*;
class Solution{
	public static void main(String [] args){
       Graph<Integer> g=new Graph<>();
       g.addEdge(2,3,true);
       g.addEdge(2,4,true);
       g.addEdge(4,5,true);
       g.addEdge(3,5,true);
       g.display();

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

	void display(){
		Set<T> hs=hm.keySet();
		for(T k:hs){
			System.out.println(k+"-->"+hm.get(k));
		}
	}

}